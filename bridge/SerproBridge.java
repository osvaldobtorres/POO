package br.com.unicap.poo.bridge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SerproBridge {
	//https://servicos.serpro.gov.br/api-serpro/biblioteca/consulta-cpf/teste.html
	
	public String getEstadoDoCpf(String cpf) {
		try {
			String url = "https://apigateway.serpro.gov.br/consulta-cpf-trial/v1/cpf/";
			String cpfFormatado = cpf;
			cpfFormatado = cpfFormatado.replace(".", "");
			cpfFormatado = cpfFormatado.replace("-", "");
			
			URL obj = new URL(url + cpfFormatado);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer 4e1a1858bdd584fdc077fb7d80f39283");
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JsonObject json = new Gson().fromJson(response.toString(), JsonObject.class);
			return json.get("situacao").getAsJsonObject().get("descricao").getAsString();
		} catch (Exception e) {
			return "CPF Não encontrado na API";
		}
	}
}
