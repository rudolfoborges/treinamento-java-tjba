package br.jus.tjba.contatos.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.jus.tjba.contatos.model.Contato;
import br.jus.tjba.contatos.service.ContatoService;

@ManagedBean
@ViewScoped
public class ContatoBean {

	private List<Contato> contatoList;
	
	private Contato contato;

	@Inject
	private ContatoService contatoService;

	
	@PostConstruct
	public void init(){
		contato = new Contato();
	}
	
	public void initList(){
		contatoList = contatoService.findAll();
	}
	
	public String save(){
		if(contato != null && contato.getId() != null){
			update(contato);
			return null;
		} else {
			return create(contato);
		}
	}
	
	public void update(Contato contato){
		
	}
	
	public String create(Contato contato){
		contatoService.create(contato);
		return "/contato/list.jsf";
	}
	
	public void remove(Long id){
		contatoService.remove(id);
		initList();
		addMessage("Contato removido com sucesso", FacesMessage.SEVERITY_INFO);
	}
	
	public void addMessage(String text, Severity severity){
		FacesMessage message = new FacesMessage();
		message.setSummary(text);
		message.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Contato> getContatoList() {
		return contatoList;
	}

	public Contato getContato() {
		return contato;
	}
	
}
