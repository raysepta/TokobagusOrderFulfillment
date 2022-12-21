package co.g2academy.tokobagusorderfulfillment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreFrontOrder {
    private Integer id;
    private Date trxDate;
    private Integer totalPrice;
    private Integer totalQuantity;
    private StoreFrontUser user;
    private List<StoreFrontOrderItem> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public StoreFrontUser getUser() {
        return user;
    }

    public void setUser(StoreFrontUser user) {
        this.user = user;
    }

    public List<StoreFrontOrderItem> getItems() {
        return items;
    }

    public void setItems(List<StoreFrontOrderItem> items) {
        this.items = items;
    }
}
