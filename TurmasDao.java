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
import modelo.Turmas;

/**
 *
 * @author ajp tech
 */
public class TurmasDao {
    
    Connection con = null;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<Turmas> lista = new ArrayList<>();
    
    public void adicionarTurma(Turmas turma) throws ClassNotFoundException {
           
           String sql = "insert into turmas (docenteId, docente, nomeTurma) values (?,?,?)";
           con = new ConexaoDao().Conexao();
           try {
               pstm = con.prepareStatement(sql);
               pstm.setInt(1, turma.getDocenteId());
               pstm.setString(2, turma.getDocente());
               pstm.setString(3, turma.getNomeTurma());
               
               pstm.execute();
              System.out.print("problema com o metodo ......................" );
           } catch (Exception e) {
               e.printStackTrace();
               System.out.print("problema com o metodo"+e);
           }
       }
    
}
