public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Início da medição
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        // Chama o QuickSort
        Quick.quickSort(data, 0, data.length - 1);

        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        long endTime = System.nanoTime(); // Fim da medição
        long duration = endTime - startTime; // Tempo total em nanossegundos

        System.out.println("Tempo de execução: " + duration + " nanosegundos");

    }
}
