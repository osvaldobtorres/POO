package br.com.unicap.poo.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.unicap.poo.dao.CandidaturaDAO;
import br.com.unicap.poo.model.Candidatura;

public class CandidaturaController {
	
	public String buscaPorId(int id) {
		CandidaturaDAO dao = new CandidaturaDAO();
		Candidatura candidatura = dao.busca(id);
	    return candidatura.toJson();
	}
	
	public String buscaPorVaga(int id) {
		CandidaturaDAO dao = new CandidaturaDAO();
		Candidatura candidatura = dao.buscaPorVaga(id);
	    return candidatura.toJson();
	}
	
	public String buscaPorEmpresa(int id) {
		CandidaturaDAO dao = new CandidaturaDAO();
		List<Candidatura> candidaturas = dao.buscaPorEmpresa(id);
	    return new Gson().toJson(candidaturas);
	}
	
	public String getTodas() {
		CandidaturaDAO dao = new CandidaturaDAO();
		List<Candidatura> candidaturas = dao.getTodas();
	    return new Gson().toJson(candidaturas);
	}
	
	public String adiciona(String conteudo, int id) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		Candidatura candidatura = null;
		try {
			candidatura = (Candidatura) new Gson().fromJson(conteudo, Candidatura.class);
		} 
		catch(JsonParseException e) {
			return mensagemErro;
		}
		boolean teste = new CandidaturaDAO().insere(candidatura, id);
		if (teste) {
			return "{\"mensagem\":\"Candidatura cadastrada com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
    }
	
	public String remove(int id) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		
		if (new CandidaturaDAO().remove(id)) {
			return "{\"mensagem\":\"Candidatura removida com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
	}
}
