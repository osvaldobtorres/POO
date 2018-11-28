package br.com.unicap.poo.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.unicap.poo.dao.VagaDAO;
import br.com.unicap.poo.model.Vaga;

public class VagaController {
	
	public String buscaPorId(int id) {
		VagaDAO dao = new VagaDAO();
		Vaga vaga = dao.busca(id);
	    return vaga.toJson();
	}
	
	public String buscaPorEmpresa(int id) {
		VagaDAO dao = new VagaDAO();
		Vaga vaga = dao.buscaPorEmpresa(id);
	    return vaga.toJson();
	}
	
	public String getTodas() {
		VagaDAO dao = new VagaDAO();
		List<Vaga> vagas = dao.getTodas();
	    return new Gson().toJson(vagas);
	}
	
	public String adiciona(String conteudo) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		Vaga vaga = null;
		try {
			vaga = (Vaga) new Gson().fromJson(conteudo, Vaga.class);
		} 
		catch(JsonParseException e) {
			return mensagemErro;
		}
		boolean teste = new VagaDAO().insere(vaga);
		if (teste) {
			return "{\"mensagem\":\"Vaga cadastrada com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
    }
	
	public String remove(int id) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		
		if (new VagaDAO().remove(id)) {
			return "{\"mensagem\":\"Vaga removida com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
	}
}
