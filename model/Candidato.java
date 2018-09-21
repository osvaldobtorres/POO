package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class Candidato {
	private String nome;
	private String cpf;
	private String dataDeNascimento;
	private String telefone;
	private String biografia;
	private String experiencia;
	private String pais;
	
	public Candidato(String nome, String cpf, String dataDeNascimento, String telefone, String biografia,
			String experiencia, String pais) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.telefone = telefone;
		this.biografia = biografia;
		this.experiencia = experiencia;
		this.pais = pais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
}
