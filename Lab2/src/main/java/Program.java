import java.util.*;

public class Program {
    public static void main(String[] args) {
        Random rand = new Random();
        Map<String, Object> objectHashMap = new HashMap<>();

        int[] integerArray = createRandomArray(1,100, 20, rand);
        List<Integer> integerList = createRandomList(1, 100, 20, rand);
        objectHashMap.put("unsortedArray", integerArray);
        objectHashMap.put("unsortedList", integerList);

        int[] sortedIntegerArray = countingSort(1, 100, integerArray);
        List<Integer> sortedIntegerList = countingSort(1,100, integerList);
        objectHashMap.put("sortedArray", sortedIntegerArray);
        objectHashMap.put("sortedList", sortedIntegerList);

        printArray((int[])objectHashMap.get("unsortedArray"), false);
        printArray((int[])objectHashMap.get("sortedArray"), true);
        printList((List<Integer>)objectHashMap.get("unsortedList"), false);
        printList((List<Integer>)objectHashMap.get("sortedList"), true);
    }

    public static int[] countingSort(int lower, int upper, int[] array){
        Map<Integer, Integer> numbersOfArray = new HashMap<>();
        int[] sortedArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            if (!numbersOfArray.containsKey(array[i])) {
                numbersOfArray.put(array[i], 1);
            }
            else {
                numbersOfArray.replace(array[i], numbersOfArray.get(array[i]) + 1);
            }
        }

        int index = 0;
        for(int i = lower; i <= upper; i++) {
            int counter = 0;
            if (numbersOfArray.containsKey(i)) {
                counter = numbersOfArray.get(i);
            }
            else {
                continue;
            }
            while (counter > 0) {
                sortedArray[index] = i;
                index++;
                counter--;
            }
        }

        return sortedArray;
    }

    public static List<Integer> countingSort(int lower, int upper, List<Integer> list){
        Map<Integer, Integer> numbersOfArray = new HashMap<>();
        List<Integer> sortedList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if (!numbersOfArray.containsKey(list.get(i))) {
                numbersOfArray.put(list.get(i), 1);
            }
            else {
                numbersOfArray.replace(list.get(i), numbersOfArray.get(list.get(i)) + 1);
            }
        }

        for(int i = lower; i <= upper; i++) {
            int counter = 0;
            if (numbersOfArray.containsKey(i)) {
                counter = numbersOfArray.get(i);
            }
            else {
                continue;
            }
            while (counter > 0) {
                sortedList.add(i);
                counter--;
            }
        }

        return sortedList;
    }

    public static int[] createRandomArray(int lower, int upper, int size, Random rand) {
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = rand.nextInt(upper) + lower;
        }

        return array;
    }

    public static List<Integer> createRandomList(int lower, int upper, int size, Random rand) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            list.add(rand.nextInt(upper) + lower);
        }

        return list;
    }

    public static void printArray(int[] array, boolean isSorted) {
        if (isSorted) {
            System.out.print("Массив после сортировки { ");
        }
        else {
            System.out.print("Массив до сортировки { ");
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("}.");
    }

    public static void printList(List<Integer> list, boolean isSorted) {
        if (isSorted) {
            System.out.print("Список после сортировки { ");
        }
        else {
            System.out.print("Список до сортировки { ");
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println("}.");
    }

}
