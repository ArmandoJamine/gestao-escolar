
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author ajp tech
 */
public class UsuarioDao {
    
    Connection con = null;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<Usuario> lista = new ArrayList<>();
    
    
    
    
    
    public void adicionarUsuario(Usuario user) throws ClassNotFoundException {

           
           String sql = "insert into usuarios (nome, apelido, funcao, email, pasword) values (?,?,?,?,?)";
//           String result="Salvo com Successo";
           con = new ConexaoDao().Conexao();
           try {
               pstm = con.prepareStatement(sql);
               pstm.setString(1, user.getNome());
               pstm.setString(2, user.getApelido());
               pstm.setString(3, user.getFuncao());
               pstm.setString(4, user.getEmail());
               pstm.setString(5, user.getPassword());
               
               pstm.executeUpdate();
           } catch (Exception e) {
//               result="Nao foi salvo o usuario";
               e.printStackTrace();
               System.out.print("problema com o metodo"+e);
           }
           
//           return result;
       }
    
    
    
}
