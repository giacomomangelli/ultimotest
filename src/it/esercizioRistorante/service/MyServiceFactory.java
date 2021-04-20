package it.esercizioRistorante.service;

import it.esercizioRistorante.dao.MyDaoFactory;
import it.esercizioRistorante.service.cliente.ClienteServiceImpl;
import it.esercizioRistorante.service.cliente.IClienteService;
import it.esercizioRistorante.service.ristorante.IRistoranteService;
import it.esercizioRistorante.service.ristorante.RistoranteServiceImpl;

public class MyServiceFactory {

	private static IClienteService clienteServiceInstance = null;
	private static IRistoranteService ristoranteServiceInstance = null;

	public static IClienteService getClienteServiceInstance() {
		if (clienteServiceInstance == null) {
			clienteServiceInstance = new ClienteServiceImpl();
			clienteServiceInstance.setClienteDao(MyDaoFactory.getClienteDaoInstance());
			clienteServiceInstance.setRistoranteDao(MyDaoFactory.getRistoranteDaoInstance());
		}
		return clienteServiceInstance;
	}

	public static IRistoranteService getRistoranteServiceInstance() {
		if (ristoranteServiceInstance == null) {
			ristoranteServiceInstance = new RistoranteServiceImpl();
			ristoranteServiceInstance.setRistoranteDao(MyDaoFactory.getRistoranteDaoInstance());
		}
		return ristoranteServiceInstance;
	}

}
