package com.aula.springBootJPAHibernate.repositories;

import com.aula.springBootJPAHibernate.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
// Criar um repositório da classe Order, uma camada responsável por acessar, salvar, buscar, atualizar e remover objetos Order no banco de dados.
