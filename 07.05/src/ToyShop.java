import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToyShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double excursionPrice = Double.parseDouble(reader.readLine());
        int puzzelsQuantity = Integer.parseInt(reader.readLine());
        int dollsQuantity = Integer.parseInt(reader.readLine());
        int bearsQuantity = Integer.parseInt(reader.readLine());
        int minionsQuantity = Integer.parseInt(reader.readLine());
        int trucksQuantity = Integer.parseInt(reader.readLine());

        double money = puzzelsQuantity*2.60 + dollsQuantity *3 + bearsQuantity *4.10 + minionsQuantity *8.20 + trucksQuantity*2;
         if (puzzelsQuantity+dollsQuantity+bearsQuantity+minionsQuantity+trucksQuantity >= 50 ){
             money *= 0.75;
         }

         money *= 0.9;

         money -= excursionPrice;

         if (money >= 0) {
             System.out.printf("Yes! %.2f lv left.", money);
         } else {
             System.out.printf("Not enough money! %.2f lv needed.", Math.abs(money));

         }
    }
}
