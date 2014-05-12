package br.jus.tjba.contatos.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Producer {

	@PersistenceContext(name="contatos", unitName="contatos")
	private EntityManager em;
	
	@Produces
	public EntityManager produce(){
		return em;
	}
	
}
