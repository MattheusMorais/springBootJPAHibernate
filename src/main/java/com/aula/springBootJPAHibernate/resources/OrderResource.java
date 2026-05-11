package com.aula.springBootJPAHibernate.resources;

import com.aula.springBootJPAHibernate.entities.Order;
import com.aula.springBootJPAHibernate.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Define a classe como um controller REST que responde HTTP e retorna JSON automaticamente
@RequestMapping(value = "/orders") // Define a rota base/endereço base deste controller
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping // Mapeia requisições HTTP GET para este metod
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders); // Retorna HTTP 200 OK com o objeto convertido para JSON
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }
}
