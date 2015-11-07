package client;

import client.commands.Direction;
import core.math.Vector2D;
import client.commands.MoveCommand;

import java.util.Random;

/**
 * Created by Pouya Payandeh on 11/5/2015.
 */
public class PlayerAI
{
    public void doTurn(WorldModel wm){
        Unit c = wm.self.agents.get(0);

        Random r= new Random();
        if(r.nextDouble() > 0.5)
            c.move(Direction.E);
        else
            c.move(Direction.W);

    }
}
