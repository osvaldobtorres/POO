package br.com.unicap.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicap.poo.Database;
import br.com.unicap.poo.model.ContaEmpresa;

public class ContaEmpresaDAO {

	public boolean insere(ContaEmpresa conta) {
		String sql = "INSERT INTO EMPRESAS (login, senha, nome, descricao, areaDeAtuacao, pais, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = Database.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, conta.getLogin());
			ps.setString(2, conta.getSenha());
			ps.setString(3, conta.getEmpresa().getNome());
			ps.setString(4, conta.getEmpresa().getDescricao());
			ps.setString(5, conta.getEmpresa().getAreaDeAtuacao());
			ps.setString(6, conta.getEmpresa().getPais());
			ps.setString(7, conta.getEmpresa().getNome());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public boolean remove(int id) {
		String sql = "DELETE FROM EMPRESAS WHERE id = ?";
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
	
	public ContaEmpresa busca(int id) {
		String sql = "SELECT * FROM EMPRESAS WHERE id = ?";
		Connection conn = null;
		
		try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ContaEmpresa conta = new ContaEmpresa(
					rs.getInt("id"),
					null,
            		null,
            		rs.getString("nome"),
            		rs.getString("descricao"),
            		rs.getString("areaDeAtuacao"),
            		rs.getString("pais"),
            		rs.getString("email")
    		);
			rs.close();
			return conta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<ContaEmpresa> getTodas() {
        String sql = "SELECT * FROM EMPRESAS";
		Connection conn = null;
		List<ContaEmpresa> contas = new ArrayList<>();

        try {
			conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ContaEmpresa conta = new ContaEmpresa(
						rs.getInt("id"),
						null,
	            		null,
	            		rs.getString("nome"),
	            		rs.getString("descricao"),
	            		rs.getString("areaDeAtuacao"),
	            		rs.getString("pais"),
	            		rs.getString("email")
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