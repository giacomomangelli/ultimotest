package it.esercizioRistorante.dao.ristorante;

import it.esercizioRistorante.dao.IBaseDAO;
import it.esercizioRistorante.model.Ristorante;

public interface IRistoranteDao extends IBaseDAO<Ristorante> {
	
	public Ristorante getEager(Long id) throws Exception;

}
