package org.garage;

public class TotalPrix {

    private double total;

    public TotalPrix(double total) {
        this.total = total;
    }

    public  TotalPrix() {}

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TotalPrix{" +
                "total=" + total +
                '}';
    }
}
