package net.thucydides.showcase.junit.model;

/**
 * Created by john on 12/11/14.
 */
public class ListingItem {
    private final String name;
    private final double price;

    public ListingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListingItem)) return false;

        ListingItem listingItem = (ListingItem) o;

        if (Double.compare(listingItem.price, price) != 0) return false;
        if (name != null ? !name.equals(listingItem.name) : listingItem.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
