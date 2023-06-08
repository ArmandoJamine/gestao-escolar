<%-- 
    Document   : AlterarF
    Created on : Jun 7, 2023, 7:44:22 AM
    Author     : ajp tech
--%>

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
            }
            
            h1{
                background: gray;
                color: white;
                padding: 10px;
            }
            
             form{
                margin-top: 20px;
                display: block; 
            }
            
            form label{
                margin-left: 400px;
                margin-top: 10px;
            }
            
            form input{
                margin-left: 400px;
                width: 350px;
                padding: 10px;
                border-radius: 5px;
                
            }
            
            form .button{
                margin-top: 10px;
                background: green;
                margin-left: 410px;
            }
            
            form label{
                display: block;
            }
        </style>
    </head>
    <body>
        <h1>Alterar faltas</h1>
        
            <form action="AlterarFaltas.jsp" method="post">
                 <p>
                    <label>Codico Faltas</label>
                    <input type="text" name="id"
                           value="<%=request.getParameter("id")%>">
                </p>
                 <p>
                    <label>Numero do estudante</label>
                    <input type="text" name="numeroEstudante"
                           value="<%=request.getParameter("numeroEstudante")%>">
                </p>
                 <p>
                    <label>Nome do estudante</label>
                    <input type="text" name="nomeEstudante"
                          value="<%=request.getParameter("nomeEstudante")%>" >
                </p>
                <p>
                    <label>Numero das faltas</label>
                    <input type="text" name="numeroFaltas" value="<%=request.getParameter("numeroFaltas")%>">
                </p>
                <input class="button" type="submit" value="Alterar">
            </form>
    </body>
</html>
