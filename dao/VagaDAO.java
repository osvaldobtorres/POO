package br.com.unicap.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicap.poo.Database;
import br.com.unicap.poo.model.Vaga;

public class VagaDAO {
	
	public boolean insere(Vaga vaga) {
		String sql = "INSERT INTO VAGAS (idEmpresa, nome, descricao, area, experienciaNecessaria) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();  
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vaga.getId());
			ps.setString(2, vaga.getNome());
			ps.setString(3, vaga.getDescricao());
			ps.setString(4, vaga.getArea());
			ps.setString(5, vaga.getExperienciaNecessaria());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public boolean remove(int id) {
		String sql = "DELETE FROM VAGAS WHERE id = ?";
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
	
	public Vaga busca(int id) {
		String sql = "SELECT * FROM VAGAS WHERE id = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
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
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public Vaga buscaPorEmpresa(int id) {
		String sql = "SELECT * FROM VAGAS WHERE idEmpresa = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
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
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Vaga> getTodas() {
        String sql = "SELECT * FROM VAGAS";
		Connection conn = null;
		List<Vaga> vagas = new ArrayList<>();

        try {
			conn = Database.getConnection();
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
			return vagas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
