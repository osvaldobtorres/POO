package br.com.unicap.poo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.unicap.poo.dao.ContaCandidatoDAO;
import br.com.unicap.poo.dao.ContaEmpresaDAO;
import br.com.unicap.poo.model.ContaCandidato;
import br.com.unicap.poo.model.ContaEmpresa;

public class CadastroController {
	
    public String adicionaEmpresa(String conteudo) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		ContaEmpresa conta = null;
		try {
			conta = (ContaEmpresa) new Gson().fromJson(conteudo, ContaEmpresa.class);
		} 
		catch(JsonParseException e) {
			return mensagemErro;
		}
		boolean teste = new ContaEmpresaDAO().insere(conta);
		if (teste) {
			return "{\"mensagem\":\"Cadastro efetuado com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
    }
	
	public String removePorIdEmpresa(int id) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		
		if (new ContaEmpresaDAO().remove(id)) {
			return "{\"mensagem\":\"Usuário removido com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
	}
	
	public String adicionaCandidato(String conteudo) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		ContaCandidato conta = null;
		try {
			conta = (ContaCandidato) new Gson().fromJson(conteudo, ContaCandidato.class);
		} 
		catch(JsonParseException e) {
			return mensagemErro;
		}
		boolean teste = new ContaCandidatoDAO().insere(conta);
		if (teste) {
			return "{\"mensagem\":\"Cadastro efetuado com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
    }
	
	public String removePorIdCandidato(int id) {
		String mensagemErro = "{\"mensagem\":\"Alguma coisa não funcionou como o esperado, certifique-se de que os dados sejam inseridos corretamente.\"}";
		
		if (new ContaCandidatoDAO().remove(id)) {
			return "{\"mensagem\":\"Usuário removido com sucesso!\"}";
		}
		else {
			return mensagemErro;
		}
	}

}