package p03_webApplicationTechnologies.ch15_servlets.sub04_multithreadingAndEmail.servlet;

import p03_webApplicationTechnologies.ch15_servlets.sub04_multithreadingAndEmail.action.MailThread;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/* # 8 # web mailer application servlet */

@WebServlet(name = "mailServlet", urlPatterns = {"/mailServlet"})
public class MailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // request mail properties from mail.properties
        Properties properties = new Properties();
        ServletContext context = getServletContext();
        String fileName = context.getInitParameter("mail");
        // load parameters to properties object
        properties.load(context.getResourceAsStream(fileName));

        MailThread mailOperator = new MailThread(req.getParameter("to"), req.getParameter("subject"), req.getParameter("body"), properties);
        // start sending process
        mailOperator.start();

        // go to page with new email create offer
        req.getRequestDispatcher("/webMailer/send.jsp").forward(req, resp);
    }
}
