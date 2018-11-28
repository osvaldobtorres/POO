package br.com.unicap.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicap.poo.factory.ConnectionFactory;
import br.com.unicap.poo.model.Vaga;

public class VagaDAO {
	
	public boolean insere(Vaga vaga) {
		String sql = "INSERT INTO VAGAS (idEmpresa, nome, descricao, area, experienciaNecessaria) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vaga.getId());
			ps.setString(2, vaga.getNome());
			ps.setString(3, vaga.getDescricao());
			ps.setString(4, vaga.getArea());
			ps.setString(5, vaga.getExperienciaNecessaria());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public boolean remove(int id) {
		String sql = "DELETE FROM VAGAS WHERE id = ?";

		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public Vaga busca(int id) {
		String sql = "SELECT * FROM VAGAS WHERE id = ?";
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Vaga conta = new Vaga(
					rs.getInt("id"),
            		rs.getString("nome"),
            		rs.getString("descricao"),
            		rs.getString("area"),
            		rs.getString("experienciaNecessaria")
    		);
			rs.close();
			ps.close();
			conn.close();
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public Vaga buscaPorEmpresa(int id) {
		String sql = "SELECT * FROM VAGAS WHERE idEmpresa = ?";

		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Vaga conta = new Vaga(
					rs.getInt("id"),
            		rs.getString("nome"),
            		rs.getString("descricao"),
            		rs.getString("area"),
            		rs.getString("experienciaNecessaria")
    		);
			rs.close();
			ps.close();
			conn.close();
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Vaga> getTodas() {
        String sql = "SELECT * FROM VAGAS";
		List<Vaga> vagas = new ArrayList<>();

        try {
        	Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vaga vaga = new Vaga(
						rs.getInt("id"),
	            		rs.getString("nome"),
	            		rs.getString("descricao"),
	            		rs.getString("area"),
	            		rs.getString("experienciaNecessaria")
	    		);
				vagas.add(vaga);
			}
			rs.close();
			ps.close();
			conn.close();
			return vagas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
