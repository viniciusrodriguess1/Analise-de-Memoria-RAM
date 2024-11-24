import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Caminho do arquivo de entrada
        String inputFile = "C:\\Users\\vinic\\Área de Trabalho\\projetos\\Analise-de-Memoria-RAM\\arq.txt";  // Substitua pelo caminho correto do arquivo

        // Lê os dados do arquivo e armazena-os em um ArrayList
        List<Integer> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;  // Se houver erro na leitura do arquivo, sai da execução
        }

        // Converte o ArrayList para um array primitivo
        int[] data = dataList.stream().mapToInt(i -> i).toArray();

        // Início da medição de tempo
        long startTime = System.nanoTime();

        // Medição de memória
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Sugere a coleta de lixo antes de medir
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Chama o método de ordenação BubbleSort
        BubbleSort.sort(data);

        // Exibe o array ordenado
        System.out.print("Array ordenado: ");
        System.out.print("[ ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.print("]");

        // Fim da medição de tempo
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime; // Tempo total em nanossegundos

        // Converte de nanossegundos para segundos
        double durationSec = durationNano / 1_000_000_000.0;  // Garantir que a conversão para segundos seja feita corretamente

        // Medição de memória após a execução
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // Exibe os resultados
        System.out.println();
        System.out.println("Tempo de execução: " + String.format("%.6f", durationSec) + " segundos");  // Exibição correta em segundos
        System.out.println("Memória usada: " + (usedMemoryAfter - usedMemoryBefore) + " bytes");
    }
}
