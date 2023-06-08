package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import dao.ConexaoDao;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background: gray;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h1{\n");
      out.write("                text-align: center;\n");
      out.write("                color: green;\n");
      out.write("                margin-top: 100px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            form{\n");
      out.write("                margin-top: 20px;\n");
      out.write("                display: block; \n");
      out.write("            }   \n");
      out.write("            \n");
      out.write("            form label{\n");
      out.write("                display: block;\n");
      out.write("                margin-left: 500px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            form input{\n");
      out.write("                margin-left: 500px;\n");
      out.write("                padding: 10px;\n");
      out.write("                background: white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            .button{\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-left: 500px;\n");
      out.write("                padding-right: 15px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                background: green;\n");
      out.write("                color: white;\n");
      out.write("                width: 100px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            a{\n");
      out.write("                display: flex; \n");
      out.write("                justify-content: center; \n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .links{\n");
      out.write("                margin-top: 100px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("        \n");
      out.write("        ");

            ConexaoDao conn = new ConexaoDao();
            Connection conexao = conn.Conexao();
        
      out.write("\n");
      out.write("        <h1>Login</h1>\n");
      out.write("        \n");
      out.write("            <form >\n");
      out.write("                 <p>\n");
      out.write("                    <label>Email</label>\n");
      out.write("                    <input style=\"padding-right: 100px\" type=\"text\" name=\"nome\" placeholder=\"Digite o email\">\n");
      out.write("                </p>\n");
      out.write("                 <p>\n");
      out.write("                    <label>Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" placeholder=\"Digite a senha\">\n");
      out.write("                </p>\n");
      out.write("                <input class=\"button\" type=\"submit\" value=\"Entrar\">\n");
      out.write("                \n");
      out.write("                ");

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
                           
      out.write("\n");
      out.write("            </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
