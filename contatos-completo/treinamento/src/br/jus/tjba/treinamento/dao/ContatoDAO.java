package br.jus.tjba.treinamento.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tjba.treinamento.model.Contato;

@ApplicationScoped
public class ContatoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public List<Contato> findAll(){
		StringBuilder hql = new StringBuilder();
		hql.append("select c from Contato c order by c.nome");
		TypedQuery<Contato> query = em.createQuery(hql.toString(), Contato.class);
		return query.getResultList();
	}
	
	public Contato findById(Long id){
		StringBuilder hql = new StringBuilder();
		hql.append("select c from Contato c where c.id = :id");
		TypedQuery<Contato> query = em.createQuery(hql.toString(), Contato.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public void update(Contato contato){
		em.merge(contato);
	}
	
	public void create(Contato contato){
		em.persist(contato);
	}
	
	public void remove(Contato contato){
		em.remove(contato);
	}
	
}
