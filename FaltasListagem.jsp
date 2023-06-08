<%-- 
    Document   : FaltasListagem
    Created on : Jun 7, 2023, 5:44:02 AM
    Author     : ajp tech
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.FaltasDao"%>
<%@page import="modelo.Faltas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Faltas</title>
    </head>
    <body>
        <%
            
            try {
                    FaltasDao uu = new FaltasDao();
                    ArrayList<Faltas> lista = uu.listarFaltas();
                    
                    for (int i = 0; i < lista.size(); i++) {
                        
                        
                            out.print("O codico da transacao e: "+ lista.get(i).getId() + "<br>");
                            out.print("O numero do estudante e: "+ lista.get(i).getNumeroEstudante()+"<br>");
                            out.print("O nome do estudante e: "+ lista.get(i).getNomeEstudante()+"<br>");
                            out.print("O numero das faltas e: "+ lista.get(i).getFaltas()+"<br>");
                            
                            out.print("<a href='ExcluirF.jsp?id="
                                    + lista.get(i).getId() + "&numeroEstudante="
                                    + lista.get(i).getNumeroEstudante()+ "&nomeEstudante="
                                    + lista.get(i).getNomeEstudante()+ "&numeroFaltas=" 
                                    + lista.get(i).getFaltas() + "'> Exluir</a>" + "<br>");
                           
                             out.print("<a href='AlterarF.jsp?id="
                                    + lista.get(i).getId() + "&numeroEstudante="
                                    + lista.get(i).getNumeroEstudante()+ "&nomeEstudante="
                                    + lista.get(i).getNomeEstudante()+ "&numeroFaltas=" 
                                    + lista.get(i).getFaltas() + "'> Editar</a>");
                            
        %> <br><br>
        <%
                                
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        %>
    </body>
</html>
