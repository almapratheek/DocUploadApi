package com.capone.model;

import java.util.List;

public class ProductObjects {

    private List<ProductObject> products;

    private int total;

    public List<ProductObject> getProducts() {
        return products;
    }

    public void setProducts(List<ProductObject> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
