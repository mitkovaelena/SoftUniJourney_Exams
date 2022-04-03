import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FootbalLeague {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double stadiumCapacity = Integer.parseInt(reader.readLine());
        double fansQuantity = Integer.parseInt(reader.readLine());
        int[] sectors = new int[4];

        for (int i = 0; i < fansQuantity; i++) {
            String sector = reader.readLine();

            switch (sector){
                case "A":
                    sectors[0]++;
                    break;
                case "B":
                    sectors[1]++;
                    break;
                case "V":
                    sectors[2]++;
                    break;
                case "G":
                    sectors[3]++;
                    break;
            }
        }

        for (int sector : sectors) {
            System.out.printf("%.2f%%", sector / fansQuantity * 100);
            System.out.println();
        }

        System.out.printf("%.2f%%", fansQuantity/stadiumCapacity*100);
    }
}
