package br.com.unicap.poo.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unicap.poo.controller.CadastroController;
import br.com.unicap.poo.controller.CandidaturaController;
import br.com.unicap.poo.controller.EmpresaController;
import br.com.unicap.poo.controller.VagaController;

@Path("empresas")
public class Empresas {
	private EmpresaController empresaCtr = new EmpresaController();
	private CadastroController cadastroCtr = new CadastroController();
	private VagaController vagaCtr = new VagaController();
	private CandidaturaController candidaturaCtr = new CandidaturaController();
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaPorId(@PathParam("id") int id) {
	    return empresaCtr.buscaPorId(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodas() {
		return empresaCtr.getTodas();
	}
	
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String removePorId(@PathParam("id") int id) {
		return cadastroCtr.removePorIdEmpresa(id);
	}
	
	@Path("{id}/vagas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getVagasPorEmpresa(@PathParam("id") int id) {
		return vagaCtr.buscaPorEmpresa(id);
	}
	
	@Path("{id}/candidaturas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaCandidaturaPorEmpresa(@PathParam("id") int id) {
		return candidaturaCtr.buscaPorVaga(id);
	}
}
