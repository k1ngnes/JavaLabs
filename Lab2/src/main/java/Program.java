import java.util.*;

public class Program {
    public static void main(String[] args) {
        Random rand = new Random();
        Map<String, Object> objectHashMap = new HashMap<>();

        int[] integerArray = createRandomArray(1,100, 20, rand);
        List<Integer> integerList = createRandomList(1, 100, 20, rand);

        printArray(integerArray);
        System.out.println();
        printList(integerList);


    }

    public static int[] countingSort

    public static int[] createRandomArray(int lower, int upper, int size, Random rand) {
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = rand.nextInt(upper + 1) + lower;
        }

        return array;
    }

    public static List<Integer> createRandomList(int lower, int upper, int size, Random rand) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            list.add(rand.nextInt(upper + 1) + lower);
        }

        return list;
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printList(List<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
