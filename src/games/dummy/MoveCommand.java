package games.dummy;

import framework.core.Game;
import framework.core.GameAgent;
import framework.core.GameCommandInterface;
import framework.core.math.Vector2D;

/**
 * Created by Pouya Payandeh on 10/16/2015.
 */
public class MoveCommand implements GameCommandInterface {
    GameAgent agent;
    Vector2D v;

    public MoveCommand(GameAgent agent, Vector2D v) {
        this.agent = agent;
        this.v = v;
    }


    @Override
    public void doCommand(Game game) {
        agent.move(v);
    }
}
