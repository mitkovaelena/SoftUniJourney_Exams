import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircumbscribedCircle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer pairs = Integer.parseInt(reader.readLine());

        for (int i = 0; i < pairs; i++) {
            List<Double> circle = Arrays.stream(reader.readLine().replace("circle ", "").split(", ")).map(Double::valueOf).collect(Collectors.toList());
            List<Double> triangle = Arrays.stream(reader.readLine().replace("triangle ", "").split(", ")).map(Double::valueOf).collect(Collectors.toList());

            // (x-a)^2 + (y-b)^2 = r^2
            StringBuilder sb = new StringBuilder();
            double i1 = Math.sqrt(Math.pow(triangle.get(0) - circle.get(0), 2) + Math.pow(triangle.get(1) - circle.get(1), 2)) - circle.get(2);
            double i2 = Math.sqrt(Math.pow(triangle.get(2) - circle.get(0), 2) + Math.pow(triangle.get(3) - circle.get(1), 2)) - circle.get(2);
            double i3 = Math.sqrt(Math.pow(triangle.get(4) - circle.get(0), 2) + Math.pow(triangle.get(5) - circle.get(1), 2)) - circle.get(2);


            if (Math.abs(i1) < 0.01 && Math.abs(i2)< 0.01 && Math.abs(i3)<0.01) {
                sb.append("The circle is circumscribed and the center is ");
            } else {
                sb.append("The circle is not circumscribed and the center is ");
            }

            if (isInside(triangle.get(0), triangle.get(1), triangle.get(2), triangle.get(3), triangle.get(4), triangle.get(5),
                    circle.get(0), circle.get(1))) {
                sb.append("inside.");
            } else {
                sb.append("outside.");
            }

            System.out.println(sb.toString());
        }
    }

    static boolean isInside(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3, Double x, Double y) {
       /* Calculate area of triangle ABC */
        double A = area(x1, y1, x2, y2, x3, y3);

       /* Calculate area of triangle PBC */
        double A1 = area(x, y, x2, y2, x3, y3);

       /* Calculate area of triangle PAC */
        double A2 = area(x1, y1, x, y, x3, y3);

       /* Calculate area of triangle PAB */
        double A3 = area(x1, y1, x2, y2, x, y);

       /* Check if sum of A1, A2 and A3 is same as A */
        return (Math.abs(A -(A1 + A2 + A3)) < 0.01);
    }

    static double area(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) +
                x3 * (y1 - y2)) / 2.0);
    }
}
