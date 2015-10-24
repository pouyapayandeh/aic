package games.JBattle.client;

import framework.network.ClientSocket;
import org.json.JSONObject;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientMain {
    public static void main(String[] args) {
        ClientSocket socket = new ClientSocket();
        ClientNetworkHandler clientNetworkHandler = new ClientNetworkHandler(socket);
        socket.connect("localhost",1111);
        JSONObject object =new JSONObject();
        object.accumulate("name","Pouya");
        socket.Response(object.toString());
    }
}
