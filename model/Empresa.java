package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class Empresa {
	private String nome;
	private String descricao;
	private String areaDeAtuacao;
	private String pais;
	private String email;

	public Empresa(String nome, String descricao, String areaDeAtuacao, String pais, String email) {
		this.nome = nome;
		this.descricao = descricao;
		this.areaDeAtuacao = areaDeAtuacao;
		this.pais = pais;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}