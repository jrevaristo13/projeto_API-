package com.digitecApi.controller;

import com.digitecApi.model.UserModel;
import com.digitecApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController // Verifique se essa linha existe
@RequestMapping("/users") // Verifique se está exatamente "/users"




public class UserController {

    @Autowired
    private UserService userService;

    // Rota para Listar Todos
    @GetMapping
    public List<UserModel> listAll() {
        return userService.listarTodos();
    }

    // Rota para Criar Usuário
    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        UserModel savedUser = userService.cadastrar(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Rota para Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable Long id) {
        try {
            UserModel user = userService.buscarPorId(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Rota para Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            userService.buscarPorId(id); // Verifica se o usuário existe
            userService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    // Rota para Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody UserModel user) {
        try {
            // Primeiro buscamos para ver se existe
            UserModel usuarioExistente = userService.buscarPorId(id);
            
            // Atualizamos os campos
            usuarioExistente.setName(user.getName());
            usuarioExistente.setEmail(user.getEmail());
            if(user.getPassword() != null) usuarioExistente.setPassword(user.getPassword());

            // Salvamos a versão atualizada
            UserModel updated = userService.cadastrar(usuarioExistente);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
