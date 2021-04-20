package it.esercizioRistorante.service.ristorante;

import java.util.List;

import javax.persistence.EntityManager;

import it.esercizioRistorante.dao.EntityManagerUtil;
import it.esercizioRistorante.dao.ristorante.IRistoranteDao;
import it.esercizioRistorante.model.Ristorante;

public class RistoranteServiceImpl implements IRistoranteService {

	private IRistoranteDao ristoranteDao;
	
	@Override
	public List<Ristorante> listAll() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
	
			ristoranteDao.setEntityManager(entityManager);

			return ristoranteDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


	@Override
	public Ristorante findById(Long inputId) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
	
			ristoranteDao.setEntityManager(entityManager);

			return ristoranteDao.get(inputId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Ristorante ristoranteInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			ristoranteDao.setEntityManager(entityManager);
			ristoranteDao.update(ristoranteInstance);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	@Override
	public void inserisci(Ristorante ristoranteInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			ristoranteDao.setEntityManager(entityManager);
			ristoranteDao.insert(ristoranteInstance);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void rimuovi(Ristorante ristoranteInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			entityManager.getTransaction().begin();
	
			ristoranteDao.setEntityManager(entityManager);
			ristoranteDao.delete(ristoranteInstance);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


	@Override
	public void setRistoranteDao(IRistoranteDao ristoranteDao) {
		this.ristoranteDao = ristoranteDao;		
	}



}
