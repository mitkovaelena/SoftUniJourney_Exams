import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CatCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        String command = reader.readLine();

        String num1 = num.substring(0,2);
        String num2 = num.substring(2,4);

        switch (command) {
            case "GCD":
                BigInteger b1 = new BigInteger(num1);
                BigInteger b2 = new BigInteger(num2);
                BigInteger gcd = b1.gcd(b2);
                System.out.println(gcd.toString());
                break;
            case "Click":
                int i1 = Integer.valueOf(new StringBuilder(num1).reverse().toString());
                int i2 = Integer.valueOf(new StringBuilder(num2).reverse().toString());

                if (i1 == i2) {
                    System.out.println("Numbers are equal!");
                } else {
                    System.out.println("Greater is: " + (i1 > i2 ? i1 : i2));
                }
                break;
            case "Meow":
                int int1 = Integer.parseInt(num1);
                int int2 = Integer.parseInt(num2);
                char ch = (char) ((int1 - int2) * (int1 % int2));
                System.out.println("The character is: " + ch);
                break;
            default:
                System.out.println("Invalid command!");

        }
    }
}
