package games.JBattle.client;

import framework.core.Game;
import framework.network.ClientSocket;
import framework.network.GameServer;
import framework.network.events.DataRecievedEvent;
import org.json.JSONObject;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientNetworkHandler implements Observer {
    ClientSocket socket;
    WorldModel wm;
    int phase = 0;
    public ClientNetworkHandler( ClientSocket socket , WorldModel wm) {
        this.socket = socket;
        this.wm=wm;
        socket.getDataRecievedEvent().addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DataRecievedEvent)
        {
            Object[] args = (Object[])arg;
            String data = (String)args[1];
            System.out.println(args[1]);
            if(phase == 0)//Terrain Data
            {
                wm.setTerrain(new JSONObject((data)));
                phase++;
            }else if(phase == 1)
            {
                wm.setGoldMines(new JSONObject(data));
                phase++;
            }else if(phase == 2)
            {
                wm.setSelf(new JSONObject(data));
            }
        }

    }
}
