package client;

import core.math.Vector2D;
import network.ClientSocket;
import network.events.DataRecievedEvent;
import client.commands.ClientMoveCommand;
import json.JSONObject;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientNetworkHandler implements Observer {
    ClientSocket socket;
    WorldModel wm;
    int phase = 0;
    boolean gameStarted=false;
    PlayerAI ai;
    public ClientNetworkHandler( ClientSocket socket , WorldModel wm,PlayerAI ai) {
        this.socket = socket;
        this.wm=wm;
        this.ai=ai;
        socket.getDataRecievedEvent().addObserver(this);
    }
    public void doTurn(JSONObject data)
    {
        wm.update(data);
        ClientMoveCommand cmd =ai.doTurn(wm);
        if(cmd != null)
            socket.response(cmd.toJSONString());
        else
            socket.response("{}");
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DataRecievedEvent)
        {
            Object[] args = (Object[])arg;
            String data = (String)args[1];
            System.out.println(args[1]);
            if(gameStarted)
            {
                doTurn(new JSONObject(data));
            }
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
                phase++;
                gameStarted=true;
            }
        }

    }
}
