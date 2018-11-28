package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class ContaEmpresa extends Conta {
	int id;
	private Empresa empresa;
	
	public ContaEmpresa(int id, String login, String senha, String nome, String descricao, 
			String areaDeAtuacao, String pais, String email) {
		this.empresa = new Empresa(nome, descricao, areaDeAtuacao, pais, email);
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
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	public String toJson() {
		return new Gson().toJson(this.empresa);
	}
}
