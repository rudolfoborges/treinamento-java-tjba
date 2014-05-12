package br.jus.tjba.contatos.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.jus.tjba.contatos.dao.ContatoDAO;
import br.jus.tjba.contatos.model.Contato;

@Stateless
public class ContatoService {
	
	@Inject
	private ContatoDAO contatoDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Contato> findAll(){
		return contatoDAO.findAll();
	}
	
	public Contato findById(Long id){
		return contatoDAO.findById(id);
	}
	
	public List<Contato> findByEmail(String email){
		return contatoDAO.findByEmail(email);
	}
	
	public void create(Contato contato){
		if(contato.getIdade() < 18){
			throw new RuntimeException("Você tem " + contato.getIdade() + " anos!");
		}
		
		if(findByEmail(contato.getEmail()).size() > 0){
			throw new RuntimeException("Email cadastrado!");
		}
		
		contato.setDataCadastro(new Date());
		
		contatoDAO.create(contato);
	}
	
	public void update(Contato contato){
		contatoDAO.update(contato);
	}
	
	public void remove(Long id){
		Contato contato = findById(id);
		contatoDAO.remove(contato);
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void checkIdade(Contato contato){
		if(contato.getIdade() < 18){
			throw new RuntimeException("Você tem " + contato.getIdade() + " anos!");
		}
	}
	
}
