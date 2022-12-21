package co.g2academy.tokobagusorderfulfillment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreFrontOrderItem {
    private Integer id;
    private Integer price;
    private Integer quantity;
    private StoreFrontProduct product;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public StoreFrontProduct getProduct() {
        return product;
    }

    public void setProduct(StoreFrontProduct product) {
        this.product = product;
    }
}
