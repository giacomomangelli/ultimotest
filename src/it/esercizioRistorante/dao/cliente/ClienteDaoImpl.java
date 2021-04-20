package it.esercizioRistorante.dao.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import it.esercizioRistorante.model.Cliente;

public class ClienteDaoImpl implements IClienteDao {
	
	private EntityManager entityManager;

	@Override
	public List<Cliente> list() throws Exception {
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();

	}

	@Override
	public Cliente get(Long id) throws Exception {
		return entityManager.find(Cliente.class, id);

	}

	@Override
	public void update(Cliente clienteIstance) throws Exception {
		if (clienteIstance == null) {
			throw new Exception("Problema valore in input");
		}
		clienteIstance = entityManager.merge(clienteIstance);
	}

	@Override
	public void insert(Cliente clienteIstance) throws Exception {
		if (clienteIstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(clienteIstance);
	}

	@Override
	public void delete(Cliente clienteIstance) throws Exception {
		if (clienteIstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(clienteIstance));
	}


	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
