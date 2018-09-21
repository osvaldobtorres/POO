package br.com.unicap.poo.model;

import com.google.gson.Gson;

public class Candidatura {
	private int id;
	private int idCandidato;
	private String coverLetter;
	private String dataDeInscricao;
	
	public Candidatura(int id, int idCandidato, String coverLetter, String dataDeInscricao) {
		this.id = id;
		this.coverLetter = coverLetter;
		this.dataDeInscricao = dataDeInscricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	public String getDataDeInscricao() {
		return dataDeInscricao;
	}
	public void setDataDeInscricao(String dataDeInscricao) {
		this.dataDeInscricao = dataDeInscricao;
	}
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
}
