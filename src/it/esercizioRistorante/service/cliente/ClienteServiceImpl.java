package it.esercizioRistorante.service.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import it.esercizioRistorante.dao.EntityManagerUtil;
import it.esercizioRistorante.dao.cliente.IClienteDao;
import it.esercizioRistorante.dao.ristorante.IRistoranteDao;
import it.esercizioRistorante.model.Cliente;
import it.esercizioRistorante.model.Ristorante;

public class ClienteServiceImpl implements IClienteService {
	
	private IClienteDao clienteDao;
	private IRistoranteDao ristoranteDao;
	
	@Override
	public void setClienteDao(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public void setRistoranteDao(IRistoranteDao ristoranteDao) {
		this.ristoranteDao = ristoranteDao;
	}
	
	@Override
	public List<Cliente> listAll() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
	
			clienteDao.setEntityManager(entityManager);

			return clienteDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


	@Override
	public Cliente findById(Long inputId) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
	
			clienteDao.setEntityManager(entityManager);

			return clienteDao.get(inputId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


	@Override
	public void aggiorna(Cliente clienteInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			clienteDao.setEntityManager(entityManager);
			clienteDao.update(clienteInstance);

			ristoranteDao.setEntityManager(entityManager);
			Ristorante ristorante = ristoranteDao.getEager(clienteDao.get(clienteInstance.getId()).getRistorante().getId());
			if(ristorante.getNumeroCoperti()<ristorante.getClienti().size()) {
				entityManager.getTransaction().commit();
			}else {
				throw new Exception("coperti massimi raggiunti");
			}
			
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}



	@Override
	public void inserisci(Cliente clienteInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			clienteDao.setEntityManager(entityManager);
			clienteDao.insert(clienteInstance);
			ristoranteDao.setEntityManager(entityManager);
			Ristorante ristorante = ristoranteDao.getEager(clienteDao.get(clienteInstance.getId()).getRistorante().getId());
			
			if(ristorante.getNumeroCoperti()<ristorante.getClienti().size()) {
				entityManager.getTransaction().commit();
			}else {
				throw new Exception("coperti massimi raggiunti");
			}
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	@Override
	public void rimuovi(Cliente clienteInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			clienteDao.setEntityManager(entityManager);
			clienteDao.delete(clienteInstance);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}



}
