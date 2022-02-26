package it.epicode.be.segreteria.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Component
public class DbLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		SegreteriaDB segreteriadb = ctx.getBean(SegreteriaDB.class);
		valorizzaDb(segreteriadb);

	}

	public void valorizzaDb(SegreteriaDB segreteriadb) {

		CorsoLaurea ingegneria = CorsoLaurea.builder().codiceCorso("ING1").nome("Ingegneria")
				.indirizzo("Dip.Ingegneria").esami(12).build();

		CorsoLaurea informatica = CorsoLaurea.builder().codiceCorso("INF2").nome("Informatica")
				.indirizzo("Dip.Informatica").esami(11).build();

		CorsoLaurea matematica = CorsoLaurea.builder().codiceCorso("MAT99").nome("Matematica")
				.indirizzo("Dip.Matematica").esami(75).build();

		Studente std1 = Studente.builder().matricola("A01").nome("Gianni").cognome("Morandi")
				.dataNascita(LocalDate.parse("2000-01-25")).email("gianni@gia.it").indirizzo("Via dei Poggi, 14")
				.cittaResidenza("Roma").corsoLaurea(ingegneria).build();

		Studente std2 = Studente.builder().matricola("A02").nome("Filippo").cognome("Bianchi")
				.dataNascita(LocalDate.parse("2001-07-30")).email("filibianchi@yum.it").indirizzo("Via dei Cedri, 18")
				.cittaResidenza("Viterbo").corsoLaurea(informatica).build();

		Studente std3 = Studente.builder().matricola("A03").nome("Maria").cognome("Balconi")
				.dataNascita(LocalDate.parse("2003-09-19")).email("mariabal@yum.it").indirizzo("Via dei Canali, 100")
				.cittaResidenza("Firenze").corsoLaurea(matematica).build();

		segreteriadb.aggiungiStudente(std1);
		segreteriadb.aggiungiStudente(std2);
		segreteriadb.aggiungiStudente(std3);
		segreteriadb.aggiungiCorso(matematica);
		segreteriadb.aggiungiCorso(informatica);
		segreteriadb.aggiungiCorso(ingegneria);
		

	}

}
