package server.commands;

import core.*;
import core.math.Vector2D;
import server.agents.Unit;

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
            if(checkPlayer(tg.currentPlayer()))
            {
                if(agent.getPos().getDistance(pos) <= 1 && board.getTerrainAt(pos)==0)
                {
                    ArrayList<BoardObject>[][] objects =tg.getBoard().getObjects();
                    Unit res = null;
                    for(BoardObject obj : objects[pos.x][pos.y])
                    {
                        if(obj instanceof Unit)
                            res = (Unit) obj;
                    }

                    if(res == null)
                    {
                        boolean res1 = objects[agent.getX()][agent.getY()].remove(agent);
                        assert (res1 == true);
                        agent.setPosition(pos);
                        objects[agent.getX()][agent.getY()].add(agent);
                    }
                }
            }
        }

}

