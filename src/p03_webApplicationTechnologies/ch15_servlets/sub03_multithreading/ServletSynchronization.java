package p03_webApplicationTechnologies.ch15_servlets.sub03_multithreading;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "ServletSynchronization", urlPatterns = {"/servletSynchronization"})
public class ServletSynchronization extends HttpServlet {
    // synchronized object
    private final StringBuilder locked = new StringBuilder();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer out = resp.getWriter();
        out.write(makeString());
        out.flush();
    }

    private String makeString() {
        // string origin
        final String SYNCHRO = "SYNCHRONIZATION";

        // try remove synchronization block and access from physically different clients and different computers
        synchronized (locked) {
            try {
                for(int i = 0; i < SYNCHRO.length(); i++) {
                    locked.append(SYNCHRO.charAt(i));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                // empty
            }
            String result = locked.toString();
            locked.delete(0, SYNCHRO.length());
            return result;
        } // synchronization block end
    }
}
