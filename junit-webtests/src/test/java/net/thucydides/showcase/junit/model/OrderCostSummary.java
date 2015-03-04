package net.thucydides.showcase.junit.model;

/**
 * Created by john on 13/11/14.
 */
public class OrderCostSummary {
    private final String name;
    private final double itemTotal;
    private final double shipping;
    private final double totalCost;

    public OrderCostSummary(String name, double itemTotal, double shipping, double totalCost) {
        this.name = name;
        this.itemTotal = itemTotal;
        this.shipping = shipping;
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public double getShipping() {
        return shipping;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
