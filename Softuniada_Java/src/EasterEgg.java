import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasterEgg {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());

        System.out.println(new String(new char[2 * n]).replace("\0", ".")
                + new String(new char[n]).replace("\0", "*")
                + new String(new char[2 * n]).replace("\0", "."));

        int m = n + 2;
        int j = 0;
        int k = 0;

        for (int i = 1; i <= n / 2; i++, m += 2) {
            System.out.println(new String(new char[(5 * n - m - 2 * i) / 2]).replace("\0", ".")
                    + new String(new char[i]).replace("\0", "*")
                    + new String(new char[m]).replace("\0", "+")
                    + new String(new char[i]).replace("\0", "*")
                    + new String(new char[(5 * n - m - 2 * i) / 2]).replace("\0", "."));
            j = i;
        }

        --j;
        m += 2 * --j;

        for (int i = 0; i < n / 2; i++, m += 2) {
            System.out.println(new String(new char[(5 * n - m - 4) / 2]).replace("\0", ".")
                    + "**"
                    + new String(new char[m]).replace("\0", "=")
                    + "**"
                    + new String(new char[(5 * n - m - 4) / 2]).replace("\0", "."));
            k = i;
        }

        m--;

        System.out.println(new String(new char[(5 * n - m - 2) / 2]).replace("\0", ".")
                + "**"
                + new String(new char[(m - 12) / 2]).replace("\0", "~")
                + "HAPPY EASTER"
                + new String(new char[(m - 12) / 2]).replace("\0", "~")
                + "**"
                + new String(new char[(5 * n - m - 2) / 2]).replace("\0", "."));

        m--;
        for (int i = 0; i < n / 2; i++, m -= 2) {
            System.out.println(new String(new char[(5 * n - m - 4) / 2]).replace("\0", ".")
                    + "**"
                    + new String(new char[m]).replace("\0", "=")
                    + "**"
                    + new String(new char[(5 * n - m - 4) / 2]).replace("\0", "."));
        }

        m -= 2 * j;

        for (int i = n / 2; i >= 1; i--, m -= 2) {
            System.out.println(new String(new char[(5 * n - m - 2 * i) / 2]).replace("\0", ".")
                    + new String(new char[i]).replace("\0", "*")
                    + new String(new char[m]).replace("\0", "+")
                    + new String(new char[i]).replace("\0", "*")
                    + new String(new char[(5 * n - m - 2 * i) / 2]).replace("\0", "."));
        }

        System.out.println(new String(new char[2 * n]).replace("\0", ".")
                + new String(new char[n]).replace("\0", "*")
                + new String(new char[2 * n]).replace("\0", "."));
    }
}
