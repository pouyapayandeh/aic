package client;

import core.math.Vector2D;
import client.commands.ClientMoveCommand;

import java.util.Random;

/**
 * Created by Pouya Payandeh on 11/5/2015.
 */
public class PlayerAI
{
    public ClientMoveCommand doTurn(WorldModel wm){
        Vector2D pos = wm.self.agents.get(0).pos.clone();
        //wm.self.agents.get(0).

        Random r= new Random();
        if(r.nextDouble() > 0.5)
            pos.setX(pos.getX()-1);
        else
            pos.setX(pos.getX()+1);



        ClientMoveCommand cmd =new ClientMoveCommand(0,pos);
        return cmd;
    }
}
