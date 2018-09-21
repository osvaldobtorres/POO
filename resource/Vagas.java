package br.com.unicap.poo.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unicap.poo.controller.CandidaturaController;
import br.com.unicap.poo.controller.VagaController;

@Path("vagas")
public class Vagas {
	private VagaController vagaCtr = new VagaController();
	private CandidaturaController candidaturaCtr = new CandidaturaController();
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaVagaPorId(@PathParam("id") int id) {
	    return vagaCtr.buscaPorId(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodasVagas() {
		return vagaCtr.getTodas();
	}
	
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String removeVagaPorId(@PathParam("id") int id) {
		return vagaCtr.remove(id);
	}
	
	@Path("{id}/candidaturas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaCandidaturaPorEmpresa(@PathParam("id") int id) {
		return candidaturaCtr.buscaPorVaga(id);
	}
	
	@Path("{id}/inscricao")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String inserirCandidatura(String conteudo, @PathParam("id") int id) {
		return candidaturaCtr.adiciona(conteudo, id);
	}
	
	@Path("{id}/inscricao")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String removeCandidatura(@PathParam("id") int id) {
		return candidaturaCtr.remove(id);
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionaVaga(String conteudo) {
		return vagaCtr.adiciona(conteudo);
    }
}
