package br.com.unicap.poo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unicap.poo.controller.CandidaturaController;

public class Candidatura {
	private CandidaturaController candidaturaCtr = new CandidaturaController();
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaPorId(@PathParam("id") int id) {
	    return candidaturaCtr.buscaPorId(id);
	}
}
