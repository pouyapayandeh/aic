package client;

import core.math.Vector2D;
import client.commands.MoveCommand;

import java.util.Random;

/**
 * Created by Pouya Payandeh on 11/5/2015.
 */
public class PlayerAI
{
    public MoveCommand doTurn(WorldModel wm){
        Vector2D pos = wm.self.agents.get(0).getPos();
        //wm.self.agents.get(0).

        Random r= new Random();
        if(r.nextDouble() > 0.5)
            pos.x--;
        else
            pos.x++;



        MoveCommand cmd =new MoveCommand(0,pos);
        return cmd;
    }
}
