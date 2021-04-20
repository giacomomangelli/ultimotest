package it.esercizioRistorante.service.ristorante;

import java.util.List;

import it.esercizioRistorante.dao.ristorante.IRistoranteDao;
import it.esercizioRistorante.model.Ristorante;


public interface IRistoranteService {
	
	public List<Ristorante> listAll() throws Exception;
	
	public Ristorante findById(Long inputId) throws Exception;
	
	public void aggiorna(Ristorante ristoranteInstance) throws Exception;
	
	public void inserisci(Ristorante ristoranteInstance) throws Exception;
	
	public void rimuovi(Ristorante ristoranteInstance) throws Exception;
	
	public void setRistoranteDao(IRistoranteDao ristoranteDao);
	
}
