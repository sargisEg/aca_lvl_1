package com.aca.exam.exam2;

public class Order {

    private final int id;
    private final String name;
    private final int price;
    private final User purchasedUser;

    public Order(int id, String name, int price, User purchasedUser) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasedUser = purchasedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof Order) {
            return id == ((Order) o).id;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (purchasedUser != null ? purchasedUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order {" +
                "\nid: " + id +
                ",\nname: " + name +
                ",\nprice: " + price +
                ",\npurchasedUser: " + purchasedUser
                + "\n}";
    }
}
