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

        char[] alphabet = new char[26];
        int lettersStart = 65;
        for(int i = 0; i < 26; i++)
        {
            alphabet[i] = (char)lettersStart++;
        }

        StringBuilder text = new StringBuilder();
        char resultLetter = '-';
        String n = String.valueOf(resultNumber);
        for (Character c : n.toCharArray()){
            resultNumber = Integer.parseInt(c.toString());
            if (resultNumber>0) {
                text.append(alphabet[resultNumber - 1]);
            }
        }


        System.out.println(text);

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
