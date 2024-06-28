package com.urfan.springjdbc;

import com.urfan.springjdbc.model.Alien;
import com.urfan.springjdbc.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Alien alien1 = context.getBean(Alien.class);
        alien1.setId(111);
        alien1.setName("Urfan");
        alien1.setTech("Java");

        AlienRepo repo = context.getBean(AlienRepo.class);
        repo.save(alien1);
        System.out.println(repo.findAll());
    }

}
