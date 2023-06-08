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
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Estudante;

/**
 *
 * @author ajp tech
 */
public class EstudanteDao {
    
    Connection con = null;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<Estudante> lista = new ArrayList<>();
    LocalDate data = LocalDate.now();
    
    
    public void adicionarEstudante(Estudante user) throws ClassNotFoundException {
           
           String sql = "insert into estudante (nome, apelido, email, nivel, dataNascimento, numeroEstudante, curso, turma) values (?,?,?,?,?,?,?,?)";
           con = new ConexaoDao().Conexao();
           try {
               pstm = con.prepareStatement(sql);
               pstm.setString(1, user.getNome());
               pstm.setString(2, user.getApelido());
               pstm.setString(3, user.getEmail());
               pstm.setString(4, user.getNivelAcademico());
               pstm.setString(5, user.getDataNascimento());
               pstm.setString(6, user.getNumeroEstudante());
               pstm.setString(7, user.getCurso());
               pstm.setString(8, user.getNomeTurma());
               
               pstm.executeUpdate();
               
           } catch (Exception e) {
               e.printStackTrace();
                System.out.print("problema com o metodo"+e);
           }
       }
    
    public ArrayList<Estudante> listarFaltasDeUmEstudante(String numeroestudante) throws ClassNotFoundException {
           String sql = "select * from faltas where numeroestudante=? ";
           con = new ConexaoDao().Conexao();
           
           try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, numeroestudante);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Estudante u = new Estudante();
                    u.setId(rs.getInt("id"));
                    u.setNumeroEstudante(rs.getString("numeroestudante"));
                    u.setNumeroEstudante(rs.getString("nomeestudante"));
                    u.setDataNascimento(rs.getString("dataNascimento"));
                    lista.add(u);
                }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return lista;
       }
}
