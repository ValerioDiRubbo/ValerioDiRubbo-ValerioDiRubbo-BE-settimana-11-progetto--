package it.epicode.be.segreteria.model;

import lombok.Builder;
import lombok.Data;

@Data
public class CorsoLaurea {

	private String codiceCorso;
	private String nome;
	private String indirizzo;
	private int esami = 10;
	
	@Builder
	public CorsoLaurea(String codiceCorso, String nome, String indirizzo, int esami) {
		this.codiceCorso = codiceCorso;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.esami = esami;
	}

	public CorsoLaurea() {
		
	}

	@Override
	public String toString() {
		return "Iscritto a :" + nome + "[codiceCorso= " + codiceCorso + ", nome= " + nome + ", indirizzo= " + indirizzo + ", esami= "
				+ esami + "]";
	}
	
	
}
