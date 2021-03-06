/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-01-12 08:08:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html ng-app>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js\"></script>\n");
      out.write("    <script src=\"resources/js/todo.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/todo.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"wrap\">\n");
      out.write("    <h2>Список дел</h2>\n");
      out.write("    <div ng-controller=\"TodoCtrl\">\n");
      out.write("        <input class=\"btn-primary populate-btn\" type=\"submit\" ng-click=\"populate()\" value=\"Заполнить список\">\n");
      out.write("        <form ng-submit=\"addTodo()\">\n");
      out.write("            <input type=\"text\" ng-model=\"todoText\"  size=\"30\"\n");
      out.write("                   placeholder=\"Введите новое дело\">\n");
      out.write("            <input class=\"btn-primary\" type=\"submit\" value=\"Добавить\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <form name = \"filterform\">\n");
      out.write("            <input type=\"radio\" ng-model=\"filter\" value=\"ALL\" > Все\n");
      out.write("            <input type=\"radio\" ng-model=\"filter\" value=\"DONE\"/> Выполненные\n");
      out.write("            <input type=\"radio\" ng-model=\"filter\" value=\"NOT_DONE\"/> Не выполненные\n");
      out.write("        </form>\n");
      out.write("        <br/>\n");
      out.write("        <div class=\"table\">\n");
      out.write("            <div class=\"table-row table-header\">\n");
      out.write("                <div class=\"header-cell cell-1\">Дело</div>\n");
      out.write("                <div class=\"header-cell cell-2\">Выполнено</div>\n");
      out.write("                <div class=\"header-cell cell-3\">Удалить</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"table-row\" ng-repeat=\"todo in todos\">\n");
      out.write("                <div class=\"table-cell cell-1\">\n");
      out.write("                    <div ng-hide=\"editorEnabled\">\n");
      out.write("                        <span class=\"done-{{todo.done}}\">{{todo.text}}</span>\n");
      out.write("                        <a class=\"pencil-link\" href=\"#\" ng-click=\"editorEnabled=!editorEnabled\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div ng-show=\"editorEnabled\">\n");
      out.write("                        <form ng-submit=\"editorEnabled=!editorEnabled; updateTodo(todo)\">\n");
      out.write("                            <input ng-model=\"todo.text\" size=\"30\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"table-cell cell-2\">\n");
      out.write("                    <input type=\"checkbox\" ng-model=\"todo.done\" ng-click=\"toggle(todo)\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"table-cell cell-3\">\n");
      out.write("                    <a class=\"del-link\" href=\"#\" ng-click=\"del(todo)\"></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
