package br.com.unicap.poo.builder;

import br.com.unicap.poo.bridge.SerproBridge;
import br.com.unicap.poo.model.ContaCandidato;

public class ContaCandidatoBuilder {
	private int id;
	private String login;
	private String senha;
	
	private String nome;
	private String cpf;
	private String estadoDoCpf;
	private String dataDeNascimento;
	private String telefone;
	private String biografia;
	private String experiencia;
	private String pais;
	
	public ContaCandidatoBuilder credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
		return this;
	}
	
	public ContaCandidatoBuilder dadosCadastrais(String nome, String cpf, String dataDeNascimento, String telefone, 
			String biografia, String experiencia, String pais) {
		this.nome = nome;
		this.cpf = cpf;
		this.estadoDoCpf = new SerproBridge().getEstadoDoCpf(this.cpf);
		this.dataDeNascimento = dataDeNascimento;
		this.telefone = telefone;
		this.biografia = biografia;
		this.experiencia = experiencia;
		this.pais = pais;

		return this;
	}
	
	public ContaCandidatoBuilder adicionaId(int id) {
		this.id = id;
		return this;
	}
	
	public ContaCandidato build() {
		return new ContaCandidato(this.id, this.login, this.senha, this.nome, this.cpf, this.dataDeNascimento, 
				this.telefone, this.biografia, this.experiencia, this.pais, this.estadoDoCpf);
	}
	
}
