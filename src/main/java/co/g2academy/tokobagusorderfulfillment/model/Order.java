package co.g2academy.tokobagusorderfulfillment.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_user", nullable = false)
    private Integer userId;
    @Column(name = "id_order_store_front", nullable = false)
    private Integer storeFrontOrderId;
    @Column(name = "order_date", nullable = false)
    private Date orderDate = new Date();
    @Column(name = "trx_date", nullable = false)
    private Date trxDate;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;
    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreFrontOrderId() {
        return storeFrontOrderId;
    }

    public void setStoreFrontOrderId(Integer storeFrontOrderId) {
        this.storeFrontOrderId = storeFrontOrderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
