package co.g2academy.tokobagusorderfulfillment.model;

import javax.persistence.*;

@Entity
@Table(name = "t_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_product", nullable = false)
    private Integer productId;
    @Column(name = "id_store_front_order_item", nullable = false)
    private Integer storeFrontOrderItemId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreFrontOrderItemId() {
        return storeFrontOrderItemId;
    }

    public void setStoreFrontOrderItemId(Integer storeFrontOrderItemId) {
        this.storeFrontOrderItemId = storeFrontOrderItemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
