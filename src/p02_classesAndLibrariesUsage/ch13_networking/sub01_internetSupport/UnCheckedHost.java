package p02_classesAndLibrariesUsage.ch13_networking.sub01_internetSupport;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* # 2 # Assigning fictitious name to real resources */

public class UnCheckedHost {
    public static void main(String[] args) {
        // set ip-address as array
        byte ip[] = {(byte) 83, (byte) 169, (byte) 197, (byte) 211}; // one of google ip
        try {
            InetAddress addr = InetAddress.getByAddress("someHostNameWhichNotExists", ip);
            System.out.println(addr.getHostName() + " => connection: " + addr.isReachable(1_000));
        } catch (UnknownHostException e) {
            System.err.println("address unreachable: " + e);
        } catch (IOException e) {
            System.err.println("thread error: " + e);
        }
    }
}
