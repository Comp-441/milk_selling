package org.apache.jsp.resources.clerck.views.produce.inputForms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import production.cow.Cow;
import java.util.ArrayList;
import reports.ProductionReport.CowsReport;

public final class AddProduce_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!-- Material form login -->\n");
      out.write("<div class=\"card\">\n");
      out.write("\n");
      out.write("    <h5 class=\"card-header  white-text text-center py-4\" style=\"background-color: #555E\">\n");
      out.write("    <strong>Add Produce</strong>\n");
      out.write("  </h5>\n");
      out.write("\n");
      out.write("  <!--Card content-->\n");
      out.write("  <div class=\"card-body px-lg-5 pt-0\">\n");
      out.write("\n");
      out.write("    <!-- Form -->\n");
      out.write("    <form class=\"text-center\" style=\"color: #757575;\" action=\"../../../../AddProduce\" method=\"post\">\n");
      out.write("\n");
      out.write("      <!-- Email -->\n");
      out.write("      <div class=\"md-form\">\n");
      out.write("        \n");
      out.write("        <select name=\"cow_id\"  class=\"form-control\">\n");
      out.write("            <option selected disabled>-- select cow---</option>\n");
      out.write("             ");
 
            
             CowsReport report=new CowsReport(); 
            
             ArrayList<Cow> list=report.getCowsReport();
            
            for(Cow cow:list){
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print( cow.getId());
      out.write('"');
      out.write('>');
      out.print( cow.getUsername() );
      out.write("</option> \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            \n");
      out.write("        </select>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Password -->\n");
      out.write("      <div class=\"md-form\">\n");
      out.write("        <input type=\"Number\" name=\"quantity\" id=\"materialLoginFormPassword\" class=\"form-control\">\n");
      out.write("        <label for=\"materialLoginFormPassword\">Quantity</label>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"form-group shadow-textarea\">\n");
      out.write("         <label for=\"exampleFormControlTextarea6\">Remarks</label>\n");
      out.write("         <textarea class=\"form-control z-depth-1\" \n");
      out.write("                   id=\"exampleFormControlTextarea6\" \n");
      out.write("                   rows=\"5\"\n");
      out.write("                   placeholder=\"Produce remarks\"\n");
      out.write("                   name=\"remarks\">\n");
      out.write("                       \n");
      out.write("         </textarea>\n");
      out.write("      </div>\n");
      out.write("  \n");
      out.write("\n");
      out.write("      <!-- Sign in button -->\n");
      out.write("      <button class=\"btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0\" type=\"submit\">Add</button>\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("    <!-- Form -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- Material form login -->");
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
