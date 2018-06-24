package com.electronicwebshop.model;

public class CartItem {

    private Proizvod proizvod;
    private int quantity;
    private double totalPrice;

    public CartItem(){}

    public CartItem(Proizvod proizvod) {
        this.proizvod = proizvod;
        this.quantity = 1;
        this.totalPrice = proizvod.getCijena();
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
