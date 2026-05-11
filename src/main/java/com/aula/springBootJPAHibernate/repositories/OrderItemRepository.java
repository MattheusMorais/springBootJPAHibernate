package com.aula.springBootJPAHibernate.repositories;

import com.aula.springBootJPAHibernate.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
// Criar um repositório da classe OrderItem, uma camada responsável por acessar, salvar, buscar, atualizar e remover objetos OrderItem no banco de dados.
