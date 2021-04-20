package it.esercizioRistorante.dao.ristorante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.esercizioRistorante.model.Ristorante;

public class RistoranteDaoImpl implements IRistoranteDao {
	
	private EntityManager entityManager;

	@Override
	public List<Ristorante> list() throws Exception {
		return entityManager.createQuery("from Ristorante", Ristorante.class).getResultList();
	}

	@Override
	public Ristorante get(Long id) throws Exception {
		return entityManager.find(Ristorante.class, id);
	}

	@Override
	public void update(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		ristoranteInstance = entityManager.merge(ristoranteInstance);
	}

	@Override
	public void insert(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(ristoranteInstance);
	}

	@Override
	public void delete(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ristoranteInstance));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Ristorante getEager(Long id) throws Exception {
		TypedQuery<Ristorante> query = entityManager.createQuery("from Ristorante r left join fetch r.cliente where r.id = ?1", Ristorante.class);
		query.setParameter(1, id);
		return query.getResultStream().findFirst().orElse(null);
	}

}
