package br.com.unicap.poo.controller;

import java.util.List;

import com.google.gson.Gson;

import br.com.unicap.poo.dao.ContaEmpresaDAO;
import br.com.unicap.poo.model.ContaEmpresa;

public class EmpresaController {
	
	public String buscaPorId(int id) {
		ContaEmpresaDAO dao = new ContaEmpresaDAO();
		ContaEmpresa conta = dao.busca(id);
	    return conta.getEmpresa().toJson();
	}
	
	public String getTodas() {
		ContaEmpresaDAO dao = new ContaEmpresaDAO();
		List<ContaEmpresa> contas = dao.getTodas();
	    return new Gson().toJson(contas);
	}
}
