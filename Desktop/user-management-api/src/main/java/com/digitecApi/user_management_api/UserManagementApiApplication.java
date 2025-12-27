

package com.digitecApi.user_management_api;



// ESTES SÃO OS IMPORTS QUE ESTAVAM FALTANDO:
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.digitecApi")
@EnableJpaRepositories(basePackages = "com.digitecApi.repository")
@EntityScan(basePackages = "com.digitecApi.model")
public class UserManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApiApplication.class, args);
    }
}