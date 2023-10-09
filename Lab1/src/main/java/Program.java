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
        int intD = (int)Math.round(d);
        int resultNumber = Math.abs(intD);

        //char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] alphabet = new char[26];
        int lettersStart = 65;
        for(int i = 0; i < 26; i++)
        {
            alphabet[i] = (char)lettersStart++;
        }

        char resultLetter;
        System.out.println(resultNumber);
        try {
            resultLetter = alphabet[resultNumber - 1];
        }
        catch (Exception e) {
            resultLetter = 'e';
        }


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
