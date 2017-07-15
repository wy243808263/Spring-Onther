package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("//ï¿½ï¿½È¡cookie   \r\n");
      out.write("function getCookie(name) {   \r\n");
      out.write("\t var nameEQ = name + \"=\";   \r\n");
      out.write("\t var ca = document.cookie.split(';');    //ï¿½ï¿½cookieï¿½Ö¸ï¿½ï¿½ï¿½ï¿½   \r\n");
      out.write("\t for(var i=0;i < ca.length;i++) {   \r\n");
      out.write("\t\t var c = ca[i];                      //È¡ï¿½ï¿½ï¿½Ö·ï¿½   \r\n");
      out.write("\t\t while (c.charAt(0)==' ') {          //ï¿½Ð¶ï¿½Ò»ï¿½ï¿½ï¿½Ö·ï¿½ï¿½ï¿½Ã»ï¿½ï¿½Ç°ï¿½ï¿½ï¿½Õ¸ï¿½   \r\n");
      out.write("\t\t\t c = c.substring(1,c.length);      //ï¿½ÐµÄ»ï¿½ï¿½ï¿½ï¿½ÓµÚ¶ï¿½Î»ï¿½ï¿½Ê¼È¡   \r\n");
      out.write("\t\t }   \r\n");
      out.write("\t\t if (c.indexOf(nameEQ) == 0) {       //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Òªï¿½ï¿½name   \r\n");
      out.write("\t\t \treturn unescape(c.substring(nameEQ.length,c.length));    //ï¿½ï¿½ï¿½ë²¢ï¿½ï¿½È¡ï¿½ï¿½ï¿½ï¿½ÒªÖµ   \r\n");
      out.write("\t\t }   \r\n");
      out.write("\t }   \r\n");
      out.write("\t return false;   \r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("//alert(getCookie('is_yj'));\r\n");
      out.write("if(getCookie('is_yj')!=null && getCookie('is_yj')=='true'){\r\n");
      out.write("\tlocation.href=\"/mh/yjpd.html\";\r\n");
      out.write("}\r\n");
      out.write("else{\r\n");
      out.write("\tlocation.href=\"/mh/index.html\";\r\n");
      out.write("\t//location.href=\"http://edu.gd.chinamobile.com/gdhtm/index.htm\";\r\n");
      out.write("\t//location.href=\"http://61.142.114.252:3083/gdhtm/index.htm\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
