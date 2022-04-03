import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BingoGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();

        int num1 = Integer.valueOf(num.charAt(0) + "" + num.charAt(2));
        int num2 = Integer.valueOf(num.charAt(1) + "" + num.charAt(3));

        int bound = num1 + num2;
        List<String> div12 = new ArrayList<>();
        List<String> div15 = new ArrayList<>();

        for (int i = num1; i <= bound; i++) {
            for (int j = num2; j <= bound; j++) {
                Integer integer = Integer.valueOf(i + "" + j);
                if (integer % 12 == 0) {
                    div12.add(String.valueOf(integer));
                }
                if (integer % 15 == 0) {
                    div15.add(String.valueOf(integer));
                }
            }
        }

        System.out.println("Dividing on 12: " + String.join(" ", div12));
        System.out.println("Dividing on 15: " + String.join(" ", div15));

        if(div12.size() == div15.size()){
            System.out.println("!!!BINGO!!!");
        } else {
            System.out.println("NO BINGO!");
        }

    }
}
