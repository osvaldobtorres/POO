package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class ContaCandidato extends Conta {
	int id;
	private Candidato candidato;
	
	public ContaCandidato(int id, String login, String senha, String nome, String cpf, 
			String dataDeNascimento, String telefone, String biografia, String experiencia, String pais, String estadoDoCpf) {
		this.candidato = new Candidato(nome, cpf, dataDeNascimento, telefone, biografia, experiencia, pais, estadoDoCpf);
		this.id = id;
		super.setLogin(login);
		super.setSenha(senha);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Candidato getCandidato() {
		return this.candidato;
	}
	
	public String toJson() {
		return new Gson().toJson(this.candidato);
	}
}
