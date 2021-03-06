package server.commands;

import core.Game;
import core.GameAgent;
import core.GameCommandInterface;
import core.GamePlayer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class BasicCommand implements GameCommandInterface {
    protected GamePlayer player;
    protected GameAgent agent;

    public BasicCommand(GamePlayer player, GameAgent agent) {
        this.player = player;
        this.agent = agent;
    }
    protected boolean checkPlayer(GamePlayer CurrentPlayer)
    {
        return (player.getPlayerId() == CurrentPlayer.getPlayerId() &&
        (agent.getOwner() == CurrentPlayer));

    }
    @Override
    public void doCommand(Game game) {

    }
}
