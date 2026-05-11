package com.aula.springBootJPAHibernate.repositories;

import com.aula.springBootJPAHibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
// Criar um repositório da classe User, uma camada responsável por acessar, salvar, buscar, atualizar e remover objetos User no banco de dados.
