package instock;


import com.google.common.collect.Ordering;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private SortedMap<String, Product> productByLabel;
    private SortedMap<Double, Map<String, Product>> productByPrice;
    private SortedMap<Integer, Map<String, Product>> productByQuantity;
    private List<String> productByIndex;

    public Instock() {
        this.productByLabel = new TreeMap<>();
        this.productByPrice = new TreeMap<>(Comparator.reverseOrder());
        this.productByQuantity = new TreeMap<>();
        this.productByIndex = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.productByIndex.size();
    }

    @Override
    public boolean contains(Product product) {
        Product p = this.productByLabel.get(product.getLabel());
        if (p == null) {
            return false;
        }
        return p.compareTo(product) == 0;
    }

    @Override
    public void add(Product product) {
        this.productByLabel.putIfAbsent(product.getLabel(), product);
        this.productByPrice.putIfAbsent(product.getPrice(), new LinkedHashMap<>());
        this.productByPrice.get(product.getPrice()).put(product.getLabel(), product);
        this.productByQuantity.putIfAbsent(product.getQuantity(), new LinkedHashMap<>());
        this.productByQuantity.get(product.getQuantity()).put(product.getLabel(), product);
        this.productByIndex.add(product.getLabel());
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        if (productByLabel.containsKey(label)) {
            Product p =  productByLabel.get(label);
            productByQuantity.get(p.getQuantity()).remove(label);
            productByLabel.get(label).setQuantity(quantity);
            this.productByQuantity.putIfAbsent(quantity, new LinkedHashMap<>());
            this.productByQuantity.get(quantity).put(label, p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        Product p = productByLabel.get(productByIndex.get(index));
        if (p == null) {
            throw new IndexOutOfBoundsException();
        }
        return p;
    }

    @Override
    public Product findByLabel(String label) {
        Product p = productByLabel.get(label);
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return p;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count > this.getCount()) {
            throw new IllegalArgumentException();
        }
        List<Product> firstNProducts = new ArrayList<>();
        Iterator<Product> productIterator = this.productByLabel.values().iterator();
        for (int i = 0; i < count; i++) {
            firstNProducts.add(productIterator.next());
        }
        return firstNProducts;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> productsInPriceRange = new ArrayList<>();
        Map<Double, Map<String, Product>> subMap = productByPrice.subMap(hi, lo);
        for (Map<String, Product> products : subMap.values()) {
            productsInPriceRange.addAll(products.values());
        }
        return productsInPriceRange;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> products = new ArrayList<>();
        Map<String, Product>  productsStrings = productByPrice.get(price);
        if (productsStrings != null) {
            products.addAll(productsStrings.values());
        }
        return products;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> mostExpensiveProducts = new ArrayList<>();
        Iterator<Map<String, Product> > iterator = this.productByPrice.values().iterator();
        for (int i = 0; i < count && iterator.hasNext(); ) {
            Map<String, Product>  productsList = iterator.next();
            for (Product p : productsList.values()) {
                if (i < count) {
                    mostExpensiveProducts.add(p);
                    i++;
                } else {
                    break;
                }
            }
        }
        if (mostExpensiveProducts.size() < count) {
            throw new IllegalArgumentException();
        }
        return mostExpensiveProducts;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> products = new ArrayList<>();
        Map<String, Product>  productsStrings = productByQuantity.get(quantity);
        if (productsStrings != null) {
            products.addAll(productsStrings.values());
        }
        return products;
    }

    @Override
    public Iterator<Product> iterator() {
        return this.productByIndex.stream().map(p-> productByLabel.get(p)).iterator();
    }
}
