package p02_classesAndLibrariesUsage.ch13_networking.sub01_internetSupport;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/* # 3 # open page from applet */

// Must be started from browser with HTML-document:
//<html>
//        <body align=center>
//        <applet code=ShowDocument.class></applet>
//</body>
//</html>

public class ShowDocument extends JApplet {
    private URL url = null;

    public String getBaseUrl() {
        return "http://google.com";
    }

    public void paint(Graphics g) {
        int timer = 0;
        g.drawString("Page loading", 10, 10);
        try {
            while (timer < 30) {
                g.drawString(".", 10 + timer * 5, 25);
                timer++;
                Thread.sleep(100);
            }
            url = new URL(getBaseUrl());
            this.getAppletContext().showDocument(url, "_blank");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // Incorrect protocol, domain name or file path
            e.printStackTrace();
        }

    }

}
