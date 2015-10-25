package games.dummy;

import framework.network.ClientSocket;
import framework.network.GameServer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class NetworkTest {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer(1111);
        gameServer.startServer();
        ClientSocket clientSocket =new ClientSocket();
        clientSocket.connect("127.0.0.1",1111);
        clientSocket.response("Hello\n");

    }
}
