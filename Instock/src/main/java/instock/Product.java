package instock;

public class Product implements Comparable<Product>{

    private String label;
    private double price;
    private int quantity;

    public Product(String label, double price, int qty) {
        this.label = label;
        this.price = price;
        this.quantity = qty;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product product) {
        if(this.label.equals(product.label) && this.price == product.price && this.quantity == product.quantity) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return this.label + " " + this.getQuantity() + " " + this.getPrice();
    }
}
