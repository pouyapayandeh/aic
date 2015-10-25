package games.JBattle.server.commands;

import framework.core.*;
import framework.core.math.Vector2D;

import java.util.ArrayList;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class MoveCommand extends BasicCommand {

    Vector2D pos;
    public MoveCommand(GamePlayer player, GameAgent agent , Vector2D pos) {
        super(player, agent);
        this.pos=pos;
    }
    @Override
    public void doCommand(Game game) {
        TurnBaseGame tg = (TurnBaseGame)game;
        GameBoard board =tg.getBoard();
            if(checkPlayer(tg.CurrentPlayer()))
            {
                if(agent.getPos().getDistance(pos) <= 1 && board.getTerrainAt(pos)==0)
                {
                    ArrayList<BoardObject>[][] objects =tg.getBoard().getObjects();
                    boolean res = objects[agent.getX()][agent.getY()].remove(agent);
                    assert (res == true);
                    agent.setPosition(pos);
                    objects[agent.getX()][agent.getY()].add(agent);
                }
            }
        }

}

