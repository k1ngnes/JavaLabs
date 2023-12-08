import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadSearch extends Thread {
    private int threadNumber;
    private BufferedReader reader;
    private AtomicInteger counter;

    public MultiThreadSearch(int threadNumber, BufferedReader reader, AtomicInteger counter) {
        this.threadNumber = threadNumber;
        this.reader = reader;
        this.counter = counter;
    }

    @Override
    public void run() {
//        System.out.println("Working with thread number: " + threadNumber);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (ch == 'e' || ch == 'E') {
                        counter.incrementAndGet();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


