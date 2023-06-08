

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ConexaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            *{
                margin: 0;
                padding: 0;
                background: gray;
            }
            
            h1{
                text-align: center;
                color: green;
                margin-top: 100px;
            }
            
            form{
                margin-top: 20px;
                display: block; 
            }   
            
            form label{
                display: block;
                margin-left: 500px;
                margin-top: 10px;
            }
            
            form input{
                margin-left: 500px;
                padding: 10px;
                background: white;
                border-radius: 5px;
            }
           
            
            .button{
                padding: 10px;
                margin-left: 500px;
                padding-right: 15px;
                margin-top: 10px;
                background: green;
                color: white;
                width: 100px;
                border-radius: 10px;
            }
            
            a{
                display: flex; 
                justify-content: center; 
                align-items: center;
            }
            
            .links{
                margin-top: 100px;
            }
            
            
        </style>
        
        
    </head>
    <body>
         
        
        <%
            ConexaoDao conn = new ConexaoDao();
            Connection conexao = conn.Conexao();
        %>
        <h1>Login</h1>
        
            <form >
                 <p>
                    <label>Email</label>
                    <input style="padding-right: 100px" type="text" name="nome" placeholder="Digite o email">
                </p>
                 <p>
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Digite a senha">
                </p>
                <input class="button" type="submit" value="Entrar">
                
                <%
                               if (conexao !=null) {
                                    if ((request.getParameter("nome") !=null) && (request.getParameter("password") !=null)) {
                                        String login, pass;
                                        login = request.getParameter("nome");
                                        pass = request.getParameter("password");
                                        Statement st;
                                        ResultSet rs, rs1;   
                                        st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                                        rs = st.executeQuery("select * from usuarios where email ='"+login+"' and pasword='"+pass+"'");
//                                        rs1 = st.executeQuery("select * from estudante where email ='"+login+"' and numeroEstudante='"+pass+"'");
                                        if(rs.next()){
                                            String perfil = rs.getString(4);
                                            if(perfil.equals("professor")){
                                                response.sendRedirect("homepage.jsp");
                                            }else if(perfil.equals("registo")){
                                                response.sendRedirect("homepage.jsp");
                                            }
                                            
                                        }else{
                                            response.sendRedirect("naoExisteEstaOpcao.html");
                                        }
                                       // out.println(login);
                                      //  out.println(pass);
                                    }
                                }else {
                                    out.println("Não é  possivel logar");
                                }
                           %>
            </form>
    </body>
</html>
