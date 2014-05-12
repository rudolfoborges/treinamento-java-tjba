package br.jus.tjba.treinamento.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.jus.tjba.treinamento.model.Contato;
import br.jus.tjba.treinamento.service.ContatoService;

@ManagedBean
@ViewScoped
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContatoService contatoService;
	
	private List<Contato> contatos;
	private Contato contato;
	private Long id;
	
	@PostConstruct
	public void init(){
		contato = new Contato();
	}
	
	public void initList(){
		contatos = contatoService.findAll();
	}
	
	public void initForm(){
		if(FacesContext.getCurrentInstance().isPostback() && getRequest().getAttribute("id") != null){
			id = (Long) getRequest().getAttribute("id");
			show(id);
		}
	}
	
	public String save(){
		if(contato != null && contato.getId() != null){
			update();
			return null;
		} else {
			return create();
		}
	}
	
	public void update(){
		contato.setId(id);
		contatoService.update(contato);
		addMessage("Registro alterado com sucesso", FacesMessage.SEVERITY_INFO);
	}
		
	public String create(){
		contatoService.create(contato);
		contato = new Contato();
		addMessage("Registro cadastrado com sucesso", FacesMessage.SEVERITY_INFO);
		return "/contato/list.jsf";
	}
	
	public void remove(Long id){
		contatoService.remove(id);
		contatos = contatoService.findAll();
		addMessage("Registro removido com sucesso", FacesMessage.SEVERITY_INFO);
	}
	
	private void show(Long id){
		contato = contatoService.findById(id);
	}
	
	public String goEdit(Long id){
		getRequest().setAttribute("id", id);
		return "/contato/form.jsf";
	}
	
	private HttpServletRequest getRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	private void addMessage(String text, Severity severity){
		FacesMessage message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(text);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
	public List<Contato> getContatos() {
		return contatos;
	}

	public Contato getContato() {
		return contato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
}
