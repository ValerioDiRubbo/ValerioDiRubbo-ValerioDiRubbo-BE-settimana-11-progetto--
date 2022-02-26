package it.epicode.be.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Configuration
public class Config {

	@Bean
	public Studente studente() {

		return new Studente();

	}

	@Bean
	@Scope("prototype")
	public CorsoLaurea corsoLaurea() {

		return new CorsoLaurea();

	}

	@Bean
	public SegreteriaDB segreteriadb() {

		return new SegreteriaDB();
	}
}
