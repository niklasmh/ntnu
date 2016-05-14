package eksamen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 14.05.2016.
 */
public class JellyBeanCustomer {
    private int id;
    private String name;
    private List<Integer> orders = new ArrayList<>();

    public JellyBeanCustomer (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void orderBeans (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cant have a negative number of beans");
        }

        this.orders.add(n);
    }

    public int getTotalBeansOrderes () {
        int sum = 0;

        for (int order : this.orders) {
            sum += order;
        }

        return sum;
    }

    public double getAverageBeansOrdered () {
        if (orders.isEmpty()) {
            return 0;
        }

        return getTotalBeansOrderes() / (double) orders.size();
    }

    public int getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String toString () {
        return this.getName() + " (" + this.getId() + "): " + this.getAverageBeansOrdered();
    }
}
