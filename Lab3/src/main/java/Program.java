import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    public static void main(String[] args) {
        String fileName = "D:\\Documents\\3-semester-term-1\\JavaLabs\\Lab3\\HarryPotterandtheMethodsofRationality.txt";

        long timerStartOneThread = System.currentTimeMillis();
        int oneThreadResult = oneThreadSearch(fileName);
        long timerEndOneThread = System.currentTimeMillis();
        long totalTimeOneThread = timerEndOneThread - timerStartOneThread;

        System.out.println("Однопоточный поиск занял: " + totalTimeOneThread + " мс");
        System.out.println("Результат однопоточного поиска: " + oneThreadResult);

        long timerStartMultiThread = System.currentTimeMillis();
        int multiThreadResult = multiThreadSearch(fileName);
        long timerEndMultiThread = System.currentTimeMillis();
        long totalTimeMultiThread = timerEndMultiThread - timerStartMultiThread;

        System.out.println("Многопоточный поиск занял: " + totalTimeMultiThread + " мс");
        System.out.println("Результат многопоточного поиска: " + multiThreadResult);
    }

    public static int oneThreadSearch(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int counter = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                for (char ch: line.toCharArray()) {
                    if (ch == 'e' || ch == 'E') {
                        counter++;
                    }
                }
            }

            reader.close();
            return counter;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int multiThreadSearch(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            AtomicInteger counter = new AtomicInteger(0);
            String line;
            MultiThreadSearch[] threads = new MultiThreadSearch[5];

            for (int i = 0; i < threads.length; i++) {
                    threads[i] = new MultiThreadSearch(i, reader, counter);
                    threads[i].start();
            }

            try {
                for (MultiThreadSearch thread: threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reader.close();
            return counter.get();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
