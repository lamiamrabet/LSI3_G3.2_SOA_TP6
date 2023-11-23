package com.example.LamiaMrabet;

import com.example.LamiaMrabet.enteties.Compte;
import com.example.LamiaMrabet.enteties.TypeCompte;
import com.example.LamiaMrabet.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class LamiaMrabetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LamiaMrabetApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteRepository cmt_rep){
		return args -> {
			cmt_rep.save(new Compte(null, 30.0, new Date(), TypeCompte.EPARGNE));
			cmt_rep.save(new Compte(null, 70.0, new Date(), TypeCompte.COURANT));
			cmt_rep.save(new Compte(null, 58.0, new Date(), TypeCompte.EPARGNE));
			cmt_rep.findAll().forEach(c ->{
				System.out.println(c.getSolde());
			});
		};
	}

}
