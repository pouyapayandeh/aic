package games.JBattle.client;

import framework.core.Game;
import framework.network.ClientSocket;
import framework.network.GameServer;
import framework.network.events.DataRecievedEvent;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientNetworkHandler implements Observer {
    ClientSocket socket;

    public ClientNetworkHandler( ClientSocket socket) {
        this.socket = socket;
        socket.getDataRecievedEvent().addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DataRecievedEvent)
        {
            Object[] args = (Object[])arg;
            System.out.println(args[1]);
        }

    }
}
