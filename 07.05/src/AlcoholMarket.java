import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlcoholMarket {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double whiskeyPrice = Double.parseDouble(reader.readLine());
        double beerQuantity = Double.parseDouble(reader.readLine());
        double wineQuantity = Double.parseDouble(reader.readLine());
        double shnapsQuantity = Double.parseDouble(reader.readLine());
        double whiskeyQuantity = Double.parseDouble(reader.readLine());

        double shnapsPrice = whiskeyPrice*0.5;
        double winePrice = shnapsPrice*0.6;
        double beerPrice = shnapsPrice*0.2;

        System.out.printf("%.2f",whiskeyPrice*whiskeyQuantity + beerPrice*beerQuantity + winePrice*wineQuantity + shnapsPrice*shnapsQuantity);

    }
}
