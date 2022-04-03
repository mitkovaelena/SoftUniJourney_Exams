import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int l = Integer.parseInt(reader.readLine());
        int specialNum = Integer.parseInt(reader.readLine());
        int controlNum = Integer.parseInt(reader.readLine());

        for (int i = m; i >= 1; i--) {
            for (int j = n; j >=1;  j--) {
                for (int k = l; k >= 1; k--) {
                    int number = i*100+j*10+k;
                    if(number % 3 == 0){
                        specialNum += 5;
                    } else if (k == 5){
                        specialNum -=2;
                    } else if (number % 2 == 0){
                        specialNum *= 2;
                    }

                    if (specialNum >= controlNum){
                        System.out.println("Yes! Control number was reached! Current special number is "+specialNum+".");
                        return;
                    }
                }
            }
        }

        System.out.println("No! "+ specialNum +" is the last reached special number.");
    }
}
