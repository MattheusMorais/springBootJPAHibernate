package com.aula.springBootJPAHibernate.services;

import com.aula.springBootJPAHibernate.entities.Product;
import com.aula.springBootJPAHibernate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements Serializable {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElse(null);
    }
}
