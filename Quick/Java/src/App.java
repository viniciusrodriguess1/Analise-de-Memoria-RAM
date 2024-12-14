import java.io.*;
import java.util.*;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        // Força o uso do ponto como separador decimal
        Locale.setDefault(Locale.US);

        // Caminho do arquivo
        String inputFile = "C:\\Users\\vinic\\Área de Trabalho\\projetos\\Analise-de-Memoria-RAM\\arq-desafio.txt";

        // Exibe informações sobre o ambiente
        System.out.println("Linguagem: Java");
        System.out.println("Versão da JVM: " + System.getProperty("java.version"));
        System.out.println("Sistema Operacional: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("Arquitetura do SO: " + System.getProperty("os.arch"));
        System.out.println("Processador: " + System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println("Memória RAM Total: " + Runtime.getRuntime().totalMemory() / 1024 + " KB");

        // Lê números do arquivo
        int[] data = readNumbersFromFile(inputFile);

        // Início da medição de tempo
        long startTime = System.nanoTime();

        // Medição de memória
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Sugere coleta de lixo antes de medir
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Chama o QuickSort
        Quick.quickSort(data, 0, data.length - 1);

        // Fim da medição de tempo
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime; // Tempo total em nanossegundos
        double durationMs = durationNano / 1_000_000.0; // Tempo em milissegundos

        // Medição de memória após a execução
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsedKB = (usedMemoryAfter - usedMemoryBefore) / 1024; // Memória usada em KB
        // Exibe os resultados
        System.out.println("Tempo de execução: " + String.format("%.2f", durationMs) + " ms");
        System.out.println("Memória usada: " + memoryUsedKB + " KB");

        // Grava o array ordenado em um arquivo
        String outputFile = "C:\\Users\\vinic\\Área de Trabalho\\projetos\\Analise-de-Memoria-RAM\\Quick\\Java\\arq-saida.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (int num : data) {
                bw.write(num + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Array ordenado salvo em: " + outputFile);
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
