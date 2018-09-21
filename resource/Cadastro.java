package br.com.unicap.poo.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unicap.poo.controller.CadastroController;


@Path("cadastro")
public class Cadastro {
	private CadastroController cadastroCtr = new CadastroController();
	
	@Path("empresa")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionaEmpresa(String conteudo) {
		return cadastroCtr.adicionaEmpresa(conteudo);
    }
	
	@Path("candidato")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionaCandidato(String conteudo) {
		return cadastroCtr.adicionaCandidato(conteudo);
    }
}
