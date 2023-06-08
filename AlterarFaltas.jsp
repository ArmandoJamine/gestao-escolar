<%-- 
    Document   : AlterarFaltas
    Created on : Jun 7, 2023, 7:46:06 AM
    Author     : ajp tech
--%>

<%@page import="dao.FaltasDao"%>
<%@page import="modelo.Faltas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            Faltas u = new Faltas();
            u.setId(Integer.parseInt(request.getParameter("id")));
            
            FaltasDao uu = new FaltasDao();
            uu.alterarFaltras(u);
            response.sendRedirect("FaltasListagem.jsp");
        %>
    </body>
</html>
