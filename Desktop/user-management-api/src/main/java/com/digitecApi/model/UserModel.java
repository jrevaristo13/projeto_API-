package com.digitecApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// construtor principal do usuario
@Entity
public class UserModel {

    // 1. Atributos (Usamos Long com L maiúsculo)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O que você pesquisou!
    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
     
    // parametizando e estaciando os atributos

 // Construtor customizado (Sem o ID, pois o banco gera automático)
 public UserModel(String name, String email, String password) {
  this.name = name;
  this.email = email;
  this.password = password;
}
 // 3. Construtor Vazio (Essencial para o Spring/Jackson)
  public UserModel(){}

  // 4. Getters e Setters (Nomes devem bater com os atributos).

  public Long getId() { 
    return id; 
}
public void setId(Long id) { 
    this.id = id; }

    public String getName(){
        return  name;
    }

    public void setName(String name){
      this.name = name;
    }

    public String getEmail(){
       return email;
    }
      public void setEmail(String email){
        this.email = email;
      }
    public String getPassword(){
      return  password;
    }
    public  void  setPassword(String password){
      this.password = password;
    }

}
