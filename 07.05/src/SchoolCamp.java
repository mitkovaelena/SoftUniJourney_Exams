import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolCamp {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String season = reader.readLine();
            String groupType = reader.readLine();
            int studentsQuantity = Integer.parseInt(reader.readLine());
            int nightsQuantity = Integer.parseInt(reader.readLine());

            Double price = 0.0;
            String sport = "";

            switch (season){
                case "Winter":
                    switch (groupType){
                        case "girls":
                            price = nightsQuantity*studentsQuantity*9.60;
                            sport = "Gymnastics";
                            break;
                        case "boys":
                            price = nightsQuantity*studentsQuantity*9.60;
                            sport = "Judo";
                            break;
                        case "mixed":
                            price = nightsQuantity*studentsQuantity*10.0;
                            sport = "Ski";
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType){
                        case "girls":
                            price = nightsQuantity*studentsQuantity*7.20;
                            sport = "Athletics";
                            break;
                        case "boys":
                            price = nightsQuantity*studentsQuantity*7.20;
                            sport = "Tennis";
                            break;
                        case "mixed":
                            price = nightsQuantity*studentsQuantity*9.50;
                            sport = "Cycling";
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType){
                        case "girls":
                            price = nightsQuantity*studentsQuantity*15.0;
                            sport = "Volleyball";
                            break;
                        case "boys":
                            price = nightsQuantity*studentsQuantity*15.0;
                            sport = "Football";
                            break;
                        case "mixed":
                            price = nightsQuantity*studentsQuantity*20.0;
                            sport = "Swimming";
                            break;
                    }
                    break;
            }

            if(studentsQuantity >= 50){
                price *= 0.5;
            } else if (studentsQuantity >= 20){
                price *= 0.85;
            } else if (studentsQuantity >= 10){
                price *= 0.95;
            }

            System.out.printf("%s %.2f lv.", sport, price);
        }
}
