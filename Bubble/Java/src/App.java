public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Início da medição
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.sort(data);

        System.out.println("Array ordenado:");
        System.out.print("[ ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.print("]");

        long endTime = System.nanoTime(); // Fim da medição
        long duration = endTime - startTime; // Tempo total em nanossegundos

        System.out.println("Tempo de execução: " + duration + " nanosegundos");
    }
}
