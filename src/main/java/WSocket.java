import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WSocket {
    public static void main(String[] args) {
        System.out.println("Server started");
        String host = "localhost";
        int port = 8887;

        WebSocketServer server = new SocketServer(new InetSocketAddress(host, port));
        server.run();
    }
}
