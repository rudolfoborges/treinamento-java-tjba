package br.jus.tjba.treinamento.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.jus.tjba.treinamento.dao.ContatoDAO;
import br.jus.tjba.treinamento.model.Contato;

@Stateless
public class ContatoService {

	@Inject
	private ContatoDAO contatoDAO;
	
	public List<Contato> findAll(){
		return contatoDAO.findAll();
	}
	
	public Contato findById(Long id){
		return contatoDAO.findById(id);
	}
	
	public void update(Contato contato){
		contatoDAO.update(contato);
	}
	
	public void create(Contato contato){
		contatoDAO.create(contato);
	}
	
	public void remove(Long id){
		Contato contato = contatoDAO.findById(id);
		contatoDAO.remove(contato);
	}
	
}
