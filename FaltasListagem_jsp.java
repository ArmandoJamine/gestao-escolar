package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dao.FaltasDao;
import modelo.Faltas;

public final class FaltasListagem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lista de Faltas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            
            try {
                    FaltasDao uu = new FaltasDao();
                    ArrayList<Faltas> lista = uu.listarFaltas();
                    
                    out.print(lista);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        
                        if(lista.size()<0){
                            out.print("tem dados");
                        }else{
                            out.print("nao te dados");
                            out.print("lista vazia");
                        }
//                            out.print("O codico da transacao e: "+ lista.get(i).getId() + "<br>");
//                            out.print("O numero do estudante e: "+ lista.get(i).getNumeroEstudante()+"<br>");
//                            out.print("O nome do estudante e: "+ lista.get(i).getNomeEstudante()+"<br>");
//                            out.print("O numero das faltas e: "+ lista.get(i).getFaltas()+"<br>");
                            
                            out.print("<a href='excluirFaltas.jsp?id="
                                    + lista.get(i).getId() + "&numeroestudante"
                                    + lista.get(i).getNomeEstudante() + "&nomeestudante"
                                    + lista.get(i).getNomeEstudante()+ "&faltas" 
                                    + lista.get(i).getFaltas() + "'> Exluir</a>");
                            
        
      out.write(" <br><br>\n");
      out.write("        ");

                                
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
      out.write("\n");
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
