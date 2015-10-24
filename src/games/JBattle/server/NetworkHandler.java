package games.JBattle.server;

import framework.core.Game;
import framework.core.GamePlayer;
import framework.core.TurnBaseGame;
import framework.core.events.GameStartEvent;
import framework.network.ClientSocket;
import framework.network.GameServer;
import framework.network.events.ClientConnectEvent;
import framework.network.events.DataRecievedEvent;

import org.json.JSONObject;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class NetworkHandler implements Observer{
    JBattleGame game;
    GameServer server;

    public NetworkHandler(JBattleGame game, GameServer server) {
        this.game = game;
        this.server = server;
        server.getClientConnectEvent().addObserver(this);
        server.getDataRecievedEvent().addObserver(this);
        game.getGameStartEvent().addObserver(this);
    }
    public void addNewPlayer(ClientSocket clientSocket , String name)
    {
        clientSocket.getOwner().setName(name);
        game.addPlayer(clientSocket.getOwner());
        clientSocket.Response(game.getBoard().toJSONString());
        clientSocket.Response(((JBPlayer) clientSocket.getOwner()).toJSONString());

    }
    public void makeNewPlayer(ClientSocket handler)
    {
        JBPlayer player = new JBPlayer();
        player.setSocket(handler);
        handler.setOwner(player);
    }
    public void gameStarted()
    {
        JBPlayer player = (JBPlayer)game.CurrentPlayer();
        player.socket.Response(player.toJSONString());
    }
    public void dataRecieved(ClientSocket clientSocket,String s)
    {
        JSONObject object =new JSONObject(s);
        System.out.println(s);
        if(object.has("name")) {
            addNewPlayer(clientSocket,(String)object.get("name"));
            if(game.isReadyToPlay())
                game.start();
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ClientConnectEvent)
        {
           makeNewPlayer((ClientSocket) arg);
        }else  if(o instanceof GameStartEvent)
        {
            server.closeJoin();
            gameStarted();
        }else  if(o instanceof DataRecievedEvent)
        {
            Object[] args =(Object[]) arg;
            dataRecieved((ClientSocket)args[0],(String)args[1]);
        }
    }
}
