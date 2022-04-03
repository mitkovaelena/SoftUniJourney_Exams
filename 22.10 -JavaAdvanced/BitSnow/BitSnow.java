import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < intArr.length-1; i++) {
            for (int j = 0; j < intArr.length-1; j++) {
                int temp = intArr[j] & intArr[j + 1];
                intArr[j + 1] = intArr[j] | intArr[j + 1];
                intArr[j] = temp;
            }
        }
        for (int i = 0; i < intArr.length; i++) {
           System.out.printf("%26s%n",Integer.toBinaryString(intArr[i]));
        }
        System.out.println(Arrays.toString(intArr).replaceAll("[\\[\\]]", ""));
    }
}