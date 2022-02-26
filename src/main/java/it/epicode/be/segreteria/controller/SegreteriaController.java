package it.epicode.be.segreteria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Controller
public class SegreteriaController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext ctx;

	public SegreteriaDB getSegreteriaDb() {
		return ctx.getBean(SegreteriaDB.class);
	}

	@GetMapping("/index")
	public String showView(Model model) {
		return "index";

	}

	/**
	 * http://localhost:8080/stampastudenti Ritorna la lista di tutti gli studenti
	 * con relativi corsi.
	 */
	@GetMapping("/stampastudenti")
	public ModelAndView stampaStudenti() {
		return new ModelAndView("studentiview", "studentiList", getSegreteriaDb().getAllStudenti());
	}

	/**
	 * http://localhost:8080/stampacorsi Ritorna la lista di tutti i corsi
	 * universitari.
	 */
	@GetMapping("/stampacorsi")
	public ModelAndView stampaCorsi() {
		return new ModelAndView("corsiview", "corsiList", getSegreteriaDb().getAllCorsiLaurea());
	}

	/**
	 * http://localhost:8080/eliminastudente/ -> inserire matricola alfanumerica da
	 * eliminare. Elimina uno studente inserendo il suo numero matricola.
	 */
	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable("matricola") String matricola) {
		
		getSegreteriaDb().cancellaStudente(matricola);
		return new ModelAndView("studentiview", "studentiList", getSegreteriaDb().getAllStudenti());
	}

	/**
	 * http://localhost:8080/eliminacorso/ -> inserire codicecorso da eliminare.
	 * Elimina un corso attraverso il suo codicecorso.
	 */
	@GetMapping("/eliminacorso/{codicecorso}")
	public ModelAndView eliminaCorso(@PathVariable("codicecorso") String codicecorso) {
		getSegreteriaDb().cancellaCorso(codicecorso);
		return new ModelAndView("corsiview", "corsiList", getSegreteriaDb().getAllCorsiLaurea());
	}

	/**
	 * Form per inserimento nuovo studente. Inserendo una stessa matricola
	 */
	@GetMapping("/studente/mostraformaggiungi")
	public ModelAndView mostraFormAggiungi(Studente studente) {

		ModelAndView modelandview = new ModelAndView("inseriscistudente", "corsiList",
				getSegreteriaDb().getAllCorsiLaurea());
		
		return modelandview;
	}

	/**
	 * Metodo che valorizza un nuovo studente tramite la form sopra e torna la view
	 * degli studenti.
	 */
	@PostMapping("/studente/inserisci")
	public String inserisciStudente(Studente studente, BindingResult result, Model model) {
		
		getSegreteriaDb().aggiungiStudente(studente);
		
		model.addAttribute("studentiList", getSegreteriaDb().getAllStudenti());
		model.addAttribute("corsiList", getSegreteriaDb().getAllCorsiLaurea());
		return "studentiview";
	}

	/**
	 * Form per inserimento nuovo corso.
	 */
	@GetMapping("/corso/mostraformaggiungi")
	public ModelAndView mostraFormAggiungiCorso(CorsoLaurea corso) {

		ModelAndView modelandview = new ModelAndView("inseriscicorso", "corsiList",
				getSegreteriaDb().getAllCorsiLaurea());
		return modelandview;
	}

	/**
	 * Metodo che valorizza un nuovo corso tramite la form sopra e torna la view dei
	 * corsi.
	 */
	@PostMapping("/corso/inserisci")
	public String inserisciCorso(CorsoLaurea corso,BindingResult result, Model model) {

		getSegreteriaDb().aggiungiCorso(corso);
		model.addAttribute("corsiList", getSegreteriaDb().getAllCorsiLaurea());
		
		return "corsiview";
	}

	
	
}
