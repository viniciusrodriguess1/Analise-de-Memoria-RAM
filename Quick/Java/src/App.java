public class App {
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // Início da medição
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Sugerir coleta de lixo antes de medir
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        // Chama o QuickSort
        Quick.quickSort(data, 0, data.length - 1);

        System.out.print("Array ordenado: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        long endTime = System.nanoTime(); // Fim da medição
        long duration = endTime - startTime; // Tempo total em nanossegundos
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println();
        System.out.println("Tempo de execução: " + duration + " nanosegundos");
        System.out.println("Memória usada: " + (usedMemoryAfter - usedMemoryBefore) + " bytes");

    }
}
