public class App {
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.sort(data);

        System.out.println("Array ordenado:");
        System.out.print("[ ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
