package br.com.unicap.poo.controller;

import java.util.List;

import com.google.gson.Gson;

import br.com.unicap.poo.dao.ContaCandidatoDAO;
import br.com.unicap.poo.model.ContaCandidato;

public class CandidatoController {
	public String buscaPorId(int id) {
		ContaCandidatoDAO dao = new ContaCandidatoDAO();
		ContaCandidato conta = dao.busca(id);
	    return conta.getCandidato().toJson();
	}
	
	public String getTodas() {
		ContaCandidatoDAO dao = new ContaCandidatoDAO();
		List<ContaCandidato> contas = dao.getTodas();
	    return new Gson().toJson(contas);
	}
}
