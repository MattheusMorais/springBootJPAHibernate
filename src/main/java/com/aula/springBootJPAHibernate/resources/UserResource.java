package com.aula.springBootJPAHibernate.resources;

import com.aula.springBootJPAHibernate.entities.User;
import com.aula.springBootJPAHibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // Define a classe como um controller REST que responde HTTP e retorna JSON automaticamente
@RequestMapping(value = "/users") // Define a rota base/endereço base deste controller
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping // Mapeia requisições HTTP GET para este metodo
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users); // Retorna HTTP 200 OK com o objeto convertido para JSON
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping // Mapeia requisições HTTP POST para este metodo
    public ResponseEntity<User> insert(@RequestBody User user) { // Converte o JSON da requisição num objeto Java User
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok(obj);
    }
}
