import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;
import FileSave.SaveToFile;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter X: ");
        double x = scanner.nextDouble();
        System.out.print("Please, enter Y: ");
        double y = scanner.nextDouble();
        System.out.print("Please, enter A: ");
        double a = scanner.nextDouble();

        double d = (Math.cos(Math.pow(x, 3) + 6) - Math.sin(y - a))/(Math.log(Math.pow(x, 4)) - 2*Math.pow(Math.sin(x), 5));

        d *=7;
        int resultNumber = (d < 0)? (int)(-d) : (int)d;

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char resultLetter = alphabet[resultNumber - 1];

        writeCharToFile(resultLetter);

        scanner.close();
    }

    public static void writeCharToFile(char symbol) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(symbol);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
