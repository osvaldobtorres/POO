package br.com.unicap.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicap.poo.Database;
import br.com.unicap.poo.model.ContaCandidato;

public class ContaCandidatoDAO {

	public boolean insere(ContaCandidato conta) {
		String sql = "INSERT INTO CANDIDATOS (login, senha, nome, cpf, telefone, biografia, experiencia, pais, dataDeNascimento)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, conta.getLogin());
			ps.setString(2, conta.getSenha());
			ps.setString(3, conta.getCandidato().getNome());
			ps.setString(4, conta.getCandidato().getCpf());
			ps.setString(5, conta.getCandidato().getTelefone());
			ps.setString(6, conta.getCandidato().getBiografia());
			ps.setString(7, conta.getCandidato().getExperiencia());
			ps.setString(8, conta.getCandidato().getPais());
			ps.setString(9, conta.getCandidato().getDataDeNascimento());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public boolean remove(int id) {
		String sql = "DELETE FROM CANDIDATOS WHERE id = ?";
		Connection conn = null;
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public ContaCandidato busca(int id) {
		String sql = "SELECT * FROM CANDIDATOS WHERE id = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ContaCandidato conta = new ContaCandidato(
					rs.getInt("id"),
					null,
            		null,
            		rs.getString("nome"),
            		rs.getString("cpf"),
            		rs.getString("dataDeNascimento"),
            		rs.getString("telefone"),
            		rs.getString("biografia"),
            		rs.getString("experiencia"),
            		rs.getString("pais")
    		);
			rs.close();
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<ContaCandidato> getTodas() {
        String sql = "SELECT * FROM CANDIDATOS";
		Connection conn = null;
		List<ContaCandidato> contas = new ArrayList<>();

        try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ContaCandidato conta = new ContaCandidato(
						rs.getInt("id"),
						null,
	            		null,
	            		rs.getString("nome"),
	            		rs.getString("cpf"),
	            		rs.getString("dataDeNascimento"),
	            		rs.getString("telefone"),
	            		rs.getString("biografia"),
	            		rs.getString("experiencia"),
	            		rs.getString("pais")
	    		);
				contas.add(conta);
			}
			rs.close();
			ps.close();
			return contas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
    }
}
