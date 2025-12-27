package com.digitecApi.service;

import com.digitecApi.model.UserModel;
import com.digitecApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // 1. Método Listar Todos (O que o Controller chama)
    public List<UserModel> listarTodos() {
        return repository.findAll();
    }

    // 2. Método Cadastrar
    public UserModel cadastrar(UserModel user) {
        return repository.save(user);
    }

    // 3. Método Buscar por ID (Usado no Get e no Delete)
    public UserModel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // 4. Método Deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}