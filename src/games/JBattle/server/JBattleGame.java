package games.JBattle.server;

import framework.core.GamePlayer;
import framework.core.TurnBaseGame;
import games.JBattle.server.agents.Castle;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class JBattleGame extends TurnBaseGame{
    int cp =0;
    final int maxPlayer =1;
    boolean started = false;

    public boolean isStarted() {
        return started;
    }

    public boolean isReadyToPlay() {
        return readyToPlay;
    }

    boolean readyToPlay=false;
    @Override
    public GamePlayer CurrentPlayer() {
        return players.get(cp);
    }

    @Override
    public void addPlayer(GamePlayer p) {
        super.addPlayer(p);
        if(players.size() >= maxPlayer)
           readyToPlay=true;
    }

    @Override
    public void start() {
        Castle castle = new Castle();
        castle.setPosition(0,4);
        addAgents(CurrentPlayer(),castle);
        started=true;
        super.start();
    }
}
