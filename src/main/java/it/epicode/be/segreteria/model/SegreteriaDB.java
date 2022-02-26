package it.epicode.be.segreteria.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SegreteriaDB {

	private Map<String, Studente> studentiList = new HashMap<String, Studente>();
	private Map<String, CorsoLaurea> corsiList = new HashMap<String, CorsoLaurea>();

	public boolean aggiungiStudente(Studente s) {
		if (!studentiList.containsValue(s)) {
			studentiList.put(s.getMatricola(), s);
		} else {
			return false;
		}

		return true;
	}

	public boolean aggiungiCorso(CorsoLaurea corso) {
		if (!corsiList.containsValue(corso)) {
			corsiList.put(corso.getCodiceCorso(), corso);
		} else {
			return false;
		}

		return true;
	}

	public boolean cancellaStudente(String matricolaS) {
		if (studentiList.containsKey(matricolaS)) {
			studentiList.remove(matricolaS);
		} else {
			return false;
		}

		return true;
	}

	public boolean cancellaCorso(String codicecorso) {
		if (corsiList.containsKey(codicecorso)) {
			corsiList.remove(codicecorso);
		} else {
			return false;
		}

		return true;
	}

	public Collection<Studente> getAllStudenti() {
		return studentiList.values();
	}

	public Collection<CorsoLaurea> getAllCorsiLaurea() {
		return corsiList.values();
	}

}
