package it.epicode.be.segreteria.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;

@Component
public class CorsoLaureaConverter implements Converter<String, CorsoLaurea> {

	@Autowired
	ApplicationContext ctx;

	/**
	 * METODO CONVERTER: converte la chiave della mappa in un oggetto dal DummyDb
	 * 
	 */

	@Override
	public CorsoLaurea convert(String codiceCorso) {
		
		
		 return (CorsoLaurea) ctx.getBean(SegreteriaDB.class).getCorsiList();
	}

}
