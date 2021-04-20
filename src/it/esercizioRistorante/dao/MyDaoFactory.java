package it.esercizioRistorante.dao;

import it.esercizioRistorante.dao.cliente.ClienteDaoImpl;
import it.esercizioRistorante.dao.cliente.IClienteDao;
import it.esercizioRistorante.dao.ristorante.IRistoranteDao;
import it.esercizioRistorante.dao.ristorante.RistoranteDaoImpl;

public class MyDaoFactory {

	private static IClienteDao clienteDaoInstance = null;
	private static IRistoranteDao ristoranteDaoInstance = null;

	public static IClienteDao getClienteDaoInstance() {
		if(clienteDaoInstance == null) {
			clienteDaoInstance = new ClienteDaoImpl();
		}
		return clienteDaoInstance;
	}
	
	public static IRistoranteDao getRistoranteDaoInstance() {
		if(ristoranteDaoInstance == null) {
			ristoranteDaoInstance = new RistoranteDaoImpl();
		}
		return ristoranteDaoInstance;
	}

}
