package p02_classesAndLibrariesUsage.ch13_networking.sub04_datagramAndUdp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

/* # 10 # file transfer via UDP protocol  */

public class UdpSender {
    public static void main(String[] args) {
        String fileName = "D:\\udpTest\\soundSend.mp3";
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
            byte[] data = new byte[1024];
            DatagramSocket dSocket = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet;

            while (fis.read(data) != -1) {
                // create data packet and send it
                packet = new DatagramPacket(data, data.length, address, 54321);
                dSocket.send(packet);
                Thread.sleep(5); // bandwidth throttling imitation
            }
            System.out.println("file successfully sent");
        } catch (UnknownHostException e) {
            // wrong recipient address
            e.printStackTrace();
        } catch (SocketException e) {
            // some troubles occurred while file sended
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
