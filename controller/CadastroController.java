package br.com.unicap.poo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.unicap.poo.builder.ContaCandidatoBuilder;
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
		boolean cadastrado = new ContaEmpresaDAO().insere(conta);
		if (cadastrado) {
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
			JsonObject json = new Gson().fromJson(conteudo, JsonObject.class);
			conta = new ContaCandidatoBuilder().credenciais(json.get("login").getAsString(), json.get("senha").getAsString())
					.dadosCadastrais(json.get("nome").getAsString(),
						json.get("cpf").getAsString(),
						json.get("dataDeNascimento").getAsString(),
						json.get("telefone").getAsString(),
						json.get("biografia").getAsString(),
						json.get("experiencia").getAsString(),
						json.get("pais").getAsString()
					)
					.build();
		} 
		catch(Exception e) {
			return mensagemErro;
		}
		boolean cadastrado = new ContaCandidatoDAO().insere(conta);
		
		if (cadastrado) {
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