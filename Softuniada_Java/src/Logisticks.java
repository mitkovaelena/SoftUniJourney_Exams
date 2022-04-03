import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class Logisticks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        SortedMap<Integer, Order> ordersByPriceDesc  = new TreeMap<>(Comparator.reverseOrder());
        SortedMap<Integer, SortedSet<Order>> ordersByDaysAsc  = new TreeMap<>();

        for (int i = 0; i < n; i++) {
           List<Integer> orderInfo =  Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
           Order order = new Order(i, orderInfo.get(0), orderInfo.get(1));
           ordersByPriceDesc.put(orderInfo.get(0), order);
           ordersByDaysAsc.putIfAbsent(orderInfo.get(1), new TreeSet<>());
           ordersByDaysAsc.get(orderInfo.get(1)).add(order);
        }

        String accDaysStr = reader.readLine();
        List<Integer> accidentDays = new ArrayList<>();
        if(!accDaysStr.equals("none")){
            accidentDays = Arrays.stream(accDaysStr.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        }

        if(accidentDays.size() > 0){
//            for (Integer accidentDay : accidentDays) {
//                Iterator iterator = ordersByDaysAsc.entrySet().iterator();
//                while (iterator.hasNext()){
//
//                }
//            }
        } else {

        }
    }

    public static class Order implements Comparable<Order>{
        private Integer index;
        private Integer price;
        private Integer day;

        public Order(Integer index, Integer price, Integer day)  {
            this.index = index;
            this.price = price;
            this.day = day;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        @Override
        public int compareTo(Order o) {
            return this.getPrice() - o.getPrice();
        }
    }

}
