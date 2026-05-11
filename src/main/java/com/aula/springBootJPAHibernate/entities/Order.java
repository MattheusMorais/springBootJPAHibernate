package com.aula.springBootJPAHibernate.entities;

import com.aula.springBootJPAHibernate.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_orders")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    @Enumerated(EnumType.STRING) // Diz como o Enum será salvo no banco
    private OrderStatus orderStatus;

    @ManyToOne // Relacionamento de muitas ordens pertencem a 1 User
    @JoinColumn(name = "client_id") // Cria a FK client_id na tabela tb_orders
    private User client;

    @OneToMany(mappedBy = "id.order") // Um Order possui vários OrderItems, e esse relacionamento é controlado pelo
    // campo order dentro do objeto id (OrderItemPK) da entidade OrderItem
    private Set<OrderItem> items =  new HashSet<>(); // Coleção de OrderItem associado a Order

    @OneToMany(mappedBy = "id.order") // Já está mapeado, não precisa criar FK com @JoinColumn
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // Mapeia as entidades para ter a mesma PK(id)
    private Payment payment;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.client = client;
        this.orderStatus = orderStatus;
        this.moment = moment;
    }

    public Order() {}

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return client;
    }

    public void setUser(User client) {
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (OrderItem oi : items) {
            total += oi.getSubtotal();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", moment=" + moment +
                '}';
    }


}
