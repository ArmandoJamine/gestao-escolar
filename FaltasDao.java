/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Faltas;

/**
 *
 * @author ajp tech
 */
public class FaltasDao {
    
    Connection con = null;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<Faltas> lista = new ArrayList<>();
    
    public void adicionarFaltras(Faltas faltas) throws ClassNotFoundException {
           String sql = "insert into faltas (numeroEstudante, nomeEstudante, numerofaltas) values (?,?,?)";
           con = new ConexaoDao().Conexao();
           try {
               pstm = con.prepareStatement(sql);
               pstm.setString(1, faltas.getNomeEstudante());
               pstm.setString(2, faltas.getNomeEstudante());
               pstm.setInt(3, faltas.getFaltas());
               
               int addRow = pstm.executeUpdate();
              
           } catch (Exception e) {
               e.printStackTrace();
           }
           
       }
      
    public ArrayList<Faltas> listarFaltas() throws ClassNotFoundException {
           String sql = "select * from faltas";
           con = ConexaoDao.Conexao();
           
           try {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Faltas u = new Faltas();
                    u.setId(rs.getInt("id"));
                    u.setNumeroEstudante(rs.getString("numeroEstudante"));
                    u.setNomeEstudante(rs.getString("nomeEstudante"));
                    u.setFaltas(rs.getInt("numeroFaltas"));
                    lista.add(u);
                }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return lista;
       }
    
    public void excluirFaltas (Faltas f) throws ClassNotFoundException{
        String sql = "delete from faltas where id=?";
        con = ConexaoDao.Conexao();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, f.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void alterarFaltras(Faltas faltas) throws ClassNotFoundException {
           String sql = "update faltas set numeroEstudante=?, nomeEstudante=?, numerofaltas=? where id=?";
           con = new ConexaoDao().Conexao();
           try {
               pstm = con.prepareStatement(sql);
               pstm.setString(1, faltas.getNumeroEstudante());
               pstm.setString(2, faltas.getNomeEstudante());
               pstm.setInt(3, faltas.getFaltas());
               pstm.setInt(4, faltas.getId());
               
               pstm.execute();
              
           } catch (Exception e) {
               e.printStackTrace();
           }
           
       }
//    
//    public ArrayList<Faltas> listarFaltasDeUmEstudante(String numeroestudante) {
//           String sql = "select * from faltas where numeroestudante=? ";
//           con = Conexao();
//           
//           try {
//                pstm = con.prepareStatement(sql);
//                pstm.setString(1, numeroestudante);
//                rs = pstm.executeQuery();
//                while (rs.next()) {
//                    Faltas u = new Faltas();
//                    u.setId(rs.getInt("id"));
//                    u.setNumeroEstudante(rs.getString("numeroestudante"));
//                    u.setNomeEstudante(rs.getString("nomeestudante"));
//                    u.setFaltas(rs.getInt("faltas"));
//                    lista.add(u);
//                }
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//           return lista;
//       }
    
}
