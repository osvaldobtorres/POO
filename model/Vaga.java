package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class Vaga {
	private int id;
	private String nome;
	private String descricao;
	private String area;
	private String experienciaNecessaria;
	
	public Vaga(int id, String nome, String descricao, String area, String experienciaNecessaria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.area = area;
		this.experienciaNecessaria = experienciaNecessaria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaNecessaria() {
		return experienciaNecessaria;
	}

	public void setExperienciaNecessaria(String experienciaNecessaria) {
		this.experienciaNecessaria = experienciaNecessaria;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
