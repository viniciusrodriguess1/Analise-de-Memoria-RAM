import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Caminho do arquivo
        String inputFile = "C:\\Users\\vinic\\Área de Trabalho\\projetos\\Analise-de-Memoria-RAM\\arq.txt"; // Ajuste o caminho conforme necessário

        // Início da medição de tempo
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Sugerir coleta de lixo antes de medir
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Lê números do arquivo e os coloca no array
        int[] data = readNumbersFromFile(inputFile);

        // Chama o QuickSort
        Quick.quickSort(data, 0, data.length - 1);

        // Exibe o array ordenado
        System.out.print("Array ordenado: ");
        System.out.print("[ ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Fim da medição de tempo
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime; // Tempo total em nanossegundos

        // Converte o tempo de execução para segundos
        double durationSec = durationNano / 1_000_000_000.0;

        // Medição de memória após a execução
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // Exibe os resultados
        System.out.println("Tempo de execução: " + String.format("%.6f", durationSec) + " segundos");
        System.out.println("Memória usada: " + (usedMemoryAfter - usedMemoryBefore) + " bytes");
    }

    // Função para ler números de um arquivo
    public static int[] readNumbersFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim())); // Adiciona o número ao array
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converte a lista para um array
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}
