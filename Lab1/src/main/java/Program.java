import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;

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
        System.out.println("Result number is " + resultNumber + ".");

        char[] alphabet = new char[26];
        int lettersStart = 65;
        for(int i = 0; i < 26; i++)
        {
            alphabet[i] = (char)lettersStart++;
        }

        StringBuilder resultText = new StringBuilder();
        String stringNumber = String.valueOf(resultNumber);
        for (Character c : stringNumber.toCharArray()){
            resultNumber = Integer.parseInt(c.toString());
            if (resultNumber > 0) {
                resultText.append(alphabet[resultNumber - 1]);
            }
        }

        System.out.println("Result text is '" + resultText + "'.");

        writeCharToFile(resultText.toString());
        scanner.close();
    }

    public static void writeCharToFile(String text) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(text);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
