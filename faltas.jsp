<%@page import="dao.FaltasDao"%>
<%@page import="modelo.Faltas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faltas</title>
        
        
    </head>
    <body>
         <%
            Faltas u = new Faltas();
            u.setNomeEstudante(request.getParameter("numeroEstudante"));
            u.setNomeEstudante(request.getParameter("nomeEstudante"));
            u.setFaltas(Integer.parseInt(request.getParameter("numerofaltas")));
            
            FaltasDao uu = new FaltasDao();
            uu.adicionarFaltras(u);
        %>
    </body>
</html>
