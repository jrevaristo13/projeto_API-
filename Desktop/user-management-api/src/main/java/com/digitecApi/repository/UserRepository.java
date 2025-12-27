package com.digitecApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitecApi.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // FIM! Não precisa escrever mais nada aqui dentro.
}