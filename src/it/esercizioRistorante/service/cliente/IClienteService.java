package it.esercizioRistorante.service.cliente;

import java.util.List;

import it.esercizioRistorante.dao.cliente.IClienteDao;
import it.esercizioRistorante.dao.ristorante.IRistoranteDao;
import it.esercizioRistorante.model.Cliente;


public interface IClienteService {
	
	public List<Cliente> listAll() throws Exception;
	
	public Cliente findById(Long inputId) throws Exception;
	
	public void aggiorna(Cliente clienteInstance) throws Exception;
	
	public void inserisci(Cliente clienteInstance) throws Exception;
	
	public void rimuovi(Cliente clienteInstance) throws Exception;
	
	public void setClienteDao(IClienteDao clienteDao);
	
	public void setRistoranteDao(IRistoranteDao ristoranteDao);

}
