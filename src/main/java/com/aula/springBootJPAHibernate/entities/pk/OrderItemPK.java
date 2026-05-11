package com.aula.springBootJPAHibernate.entities.pk;

import com.aula.springBootJPAHibernate.entities.Order;
import com.aula.springBootJPAHibernate.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable // Classe responsável pela PK composta de OrderItem, OrderItem precisa da PK order_id + product_id
public class OrderItemPK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // Hibernate vai converter os Objetos para order_id e product_id no banco, APENAS, nao vai os outros atributos!

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItemPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderItemPK() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }


}
