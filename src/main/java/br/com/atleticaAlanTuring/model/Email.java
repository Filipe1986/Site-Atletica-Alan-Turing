package br.com.atleticaAlanTuring.model;


public class Email{
	
	@org.hibernate.validator.constraints.Email
	private String remetente;

	private String nome;
	private String sobrenome;
	private String periodo;
	private String matricula;
	
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String período) {
		this.periodo = período;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
			
			return "Email: "+ remetente+ " - nome: "+ nome;
	}
	

}
