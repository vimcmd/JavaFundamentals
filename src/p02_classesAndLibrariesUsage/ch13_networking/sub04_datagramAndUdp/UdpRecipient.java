package p02_classesAndLibrariesUsage.ch13_networking.sub04_datagramAndUdp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/* # 11 # file receive via UDP protocol */

public class UdpRecipient {
    public static void main(String[] args) {
        File file = new File("D:\\udpTest\\soundReceive.mp3");
        System.out.println("file receiving...");
        acceptFile(file, 54321, 1024);
    }

    private static void acceptFile(File file, int port, int packetSize) {
        byte[] data = new byte[packetSize];
        DatagramPacket dPacket = new DatagramPacket(data, data.length);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            DatagramSocket s = new DatagramSocket(port);
            // set wait timeout interval
            s.setSoTimeout(10_000); // 10 sec
            while (true) {
                // if no packets received in timeout interval, data transfer ended with raised exception
                s.receive(dPacket);
                fos.write(data);
                fos.flush();
            }
        } catch (SocketException e) {
            System.err.println("wait timeout: " + e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
