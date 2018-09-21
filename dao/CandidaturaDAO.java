package br.com.unicap.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicap.poo.Database;
import br.com.unicap.poo.model.Candidatura;

public class CandidaturaDAO {

	public boolean insere(Candidatura candidatura, int idVaga) {
		String sql = "INSERT INTO CANDIDATURAS (idVaga, idCandidato, coverLetter, dataDeInscricao) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idVaga);
			ps.setInt(2, candidatura.getId());
			ps.setString(3, candidatura.getCoverLetter());
			ps.setString(4, candidatura.getDataDeInscricao());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public boolean remove(int id) {
		String sql = "DELETE FROM CANDIDATURAS WHERE id = ?";
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
	
	public Candidatura busca(int id) {
		String sql = "SELECT * FROM VAGAS WHERE id = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Candidatura candidatura = new Candidatura(
					rs.getInt("id"),
            		rs.getInt("idCandidato"),
            		rs.getString("coverLetter"),
            		rs.getString("dataDeInscricao")
    		);
			rs.close();
			ps.close();
			return candidatura;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public Candidatura buscaPorVaga(int id) {
		String sql = "SELECT * FROM VAGAS WHERE idVaga = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Candidatura candidatura = new Candidatura(
					rs.getInt("id"),
            		rs.getInt("idCandidato"),
            		rs.getString("coverLetter"),
            		rs.getString("dataDeInscricao")
    		);
			rs.close();
			ps.close();
			return candidatura;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Candidatura> buscaPorEmpresa(int id) {
		String sql = "SELECT * FROM VAGAS WHERE idEmpresa = ?";
		Connection conn = null;
		List<Candidatura> candidaturas = new ArrayList<>();
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Candidatura candidatura = new Candidatura(
						rs.getInt("idVaga"),
	            		rs.getInt("idCandidato"),
	            		rs.getString("coverLetter"),
	            		rs.getString("dataDeInscricao")
	    		);
				candidaturas.add(candidatura);
			}
			rs.close();
			ps.close();
			return candidaturas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Candidatura> getTodas() {
        String sql = "SELECT * FROM VAGAS";
		Connection conn = null;
		List<Candidatura> candidaturas = new ArrayList<>();

        try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Candidatura candidatura = new Candidatura(
						rs.getInt("id"),
	            		rs.getInt("idCandidato"),
	            		rs.getString("coverLetter"),
	            		rs.getString("dataDeInscricao")
	    		);
				candidaturas.add(candidatura);
			}
			rs.close();
			ps.close();
			return candidaturas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
