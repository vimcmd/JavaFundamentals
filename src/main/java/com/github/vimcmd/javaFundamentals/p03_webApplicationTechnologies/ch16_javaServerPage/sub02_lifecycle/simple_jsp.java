package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch16_javaServerPage.sub02_lifecycle;

import org.apache.jasper.runtime.HttpJspBase;
import org.apache.jasper.runtime.JspSourceDependent;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import java.io.IOException;
import java.util.Map;

/* # 3 # generated servlet on server side */

public class simple_jsp extends HttpJspBase implements JspSourceDependent {

    private static Map<String, Long> _jspx_dependants;

    @Override
    public void _jspService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        JspWriter _jspx_out = null;
        PageContext _jspx_page_context = null;

        try {
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html");
            pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;


            out.write("<html><head>\r\n");
            out.write("<title>Simple</title>\r\n");
            out.write("</head>\r\n");
            out.write("<body>\r\n");
            out.write("Hello, Bender\r\n");
            out.write("</body></html>\r\n");

        } catch (Throwable t) {
            if (!(t instanceof SkipPageException )) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0) {
                    out.clearBuffer();
                }
                if (_jspx_page_context != null) {
                    _jspx_page_context.handlePageException(t);
                }
            }
        } finally {
            if (_jspx_page_context != null) {
                _jspxFactory.releasePageContext(_jspx_page_context);
            }
        }
    }

    @Override
    public Map<String, Long> getDependants() {
        return _jspx_dependants;
    }
}
