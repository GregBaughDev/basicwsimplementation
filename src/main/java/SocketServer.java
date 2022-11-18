import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class SocketServer extends WebSocketServer {
    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connection closed");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message: " + message );
        test(conn);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("Socket error!");
    }

    @Override
    public void onStart() {
        System.out.println("Started!");
    }

    public void test(WebSocket conn) {
        conn.send("Message sent from test method");
    }
}
