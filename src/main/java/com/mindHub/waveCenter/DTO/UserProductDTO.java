package com.mindHub.waveCenter.DTO;

public class UserProductDTO {

    private long id;

    private double price;

    private productType productType;


    public UserProductDTO(UserProduct userProduct) {
        this.id = userProduct.getId();
        this.price = userProduct.getPrice();
        this.productType = userProduct.getProductType();
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public productType getProductType() {
        return productType;
    }
}
