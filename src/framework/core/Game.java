package framework.core;

import framework.core.events.GameStartEvent;

import java.util.ArrayList;

/**
 *
 * Created by Pouya Payandeh on 10/11/2015.
 */
public class Game {
    protected GameBoard board;
    protected  ArrayList<GamePlayer> players;

    public ArrayList<BoardObject> getBoardObjects() {
        return objects;
    }

    protected  ArrayList<BoardObject> objects;
    protected GameStartEvent gameStartEvent;
    public ArrayList<GameAgent> getAllAgents()
    {
        ArrayList<GameAgent> agents=new ArrayList<GameAgent>();
        for(GamePlayer player : players)
        {
            agents.addAll(player.agents);
        }
        return agents;
    }


    public Game() {
        players=new ArrayList<GamePlayer>();
        gameStartEvent = new GameStartEvent();
        objects = new ArrayList<>();
    }

    public GameStartEvent getGameStartEvent() {
        return gameStartEvent;
    }

    public void addPlayer(GamePlayer p)
    {
        p.playerId=players.size();
        players.add(p);
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public GameBoard getBoard() {

        return board;
    }

    public void addAgents(GamePlayer p , GameAgent agent)
    {
        agent.agentId=p.agents.size();
        p.agents.add(agent);
        board.objects[agent.getX()][agent.getY()].add(agent);
    }
    public void addObject(BoardObject obj)
    {
        objects.add(obj);
        board.objects[obj.getX()][obj.getY()].add(obj);
    }
    public void start(){
        gameStartEvent.notifyObservers(null);
    }

}
