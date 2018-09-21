package br.com.unicap.poo;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
        ResourceConfig config = new ResourceConfig().packages("br.com.unicap.poo.resource");
        URI uri = URI.create("http://localhost:8080/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        Database.createConnection();
        System.out.println("Servidor rodando");
        System.in.read();
        Database.closeConnection();
        server.stop();
    }
}