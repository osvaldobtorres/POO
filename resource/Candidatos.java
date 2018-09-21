package br.com.unicap.poo.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unicap.poo.controller.CadastroController;
import br.com.unicap.poo.controller.CandidatoController;

@Path("candidatos")
public class Candidatos {
	private CandidatoController candidatoCtr = new CandidatoController();
	private CadastroController cadastroCtr = new CadastroController();
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaPorId(@PathParam("id") int id) {
	    return candidatoCtr.buscaPorId(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodas() {
		return candidatoCtr.getTodas();
	}
	
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String removePorId(@PathParam("id") int id) {
		return cadastroCtr.removePorIdCandidato(id);
	}
}