import java.io.*;
import java.net.*;

public class Consumer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4445);
        byte[] buf = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Consumed: " + received);

            // Send acknowledgment
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] ackBuf = "ACK".getBytes();
            DatagramPacket ackPacket = new DatagramPacket(ackBuf, ackBuf.length, address, port);
            socket.send(ackPacket);
        }
    }
}

