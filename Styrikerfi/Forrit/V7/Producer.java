import java.io.*;
import java.net.*;

public class Producer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 4445;
        byte[] buf;
        int sequenceNumber = 1;

        while (true) {
            String data = Integer.toString(sequenceNumber);
            buf = data.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            System.out.println("Produced: " + data);

            // Wait for acknowledgment
            byte[] ackBuf = new byte[256];
            DatagramPacket ackPacket = new DatagramPacket(ackBuf, ackBuf.length);
            socket.receive(ackPacket);
            String received = new String(ackPacket.getData(), 0, ackPacket.getLength());
            if ("ACK".equals(received)) {
                sequenceNumber++;
            } else {
                System.out.println("No ACK received. Resending data: " + data);
            }
        }
    }
}

