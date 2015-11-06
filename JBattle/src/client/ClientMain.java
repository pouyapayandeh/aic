package client;

import network.ClientSocket;
import json.JSONObject;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientMain {
    public static void main(String[] args) {
        ClientSocket socket = new ClientSocket();
        WorldModel wm = new WorldModel();
        PlayerAI ai = new PlayerAI();
        ClientNetworkHandler clientNetworkHandler = new ClientNetworkHandler(socket,wm,ai);
        socket.connect("localhost",1111);
        JSONObject object =new JSONObject();
        object.accumulate("name","Pouya");
        socket.response(object.toString());
    }
}
