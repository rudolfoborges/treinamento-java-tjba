package br.jus.tjba.treinamento.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceProducer {

	
	@PersistenceContext(unitName="treinamento", name="treinamento")
	private EntityManager em;
	
	
	@Produces
	public EntityManager producer(){
		return em;
	}
	
}
