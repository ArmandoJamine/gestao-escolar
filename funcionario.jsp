

<%@page import="modelo.Usuario"%>
<%@page import="dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de funcionario</title>
        
       
    </head>
    <body>
        
        <%
            Usuario u = new Usuario();
            u.setNome(request.getParameter("nome"));
            u.setApelido(request.getParameter("apelido"));
            u.setFuncao(request.getParameter("funcao"));
            u.setEmail(request.getParameter("email"));
            u.setPassword(request.getParameter("password"));
            
            UsuarioDao uu = new UsuarioDao();
            uu.adicionarUsuario(u);
        %>
         
    </body>
</html>
