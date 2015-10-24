package games.JBattle.server;

import framework.core.Game;
import framework.core.MapBoard;
import framework.graphics.JFrameWrap;
import framework.network.GameServer;
import games.JBattle.server.graphics.JBattleGR;
import games.JBattle.server.objects.GoldMine;
import sun.nio.ch.Net;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ServerMain {
    public static void main(String[] args) {
        JFrameWrap frameWrap =new JFrameWrap();
        MapBoard b = new MapBoard("f:\\map.txt");
        b.initBoard();
        JBattleGame g = new JBattleGame();
        g.setBoard(b);
        g.addObject(new GoldMine(500,0,0));
        JBattleGR jBattleGR =new JBattleGR(g);
        frameWrap.initUI(jBattleGR);
        GameServer server = new GameServer(1111);
        NetworkHandler networkHandler = new NetworkHandler(g,server);
        server.startServer();
    }
}
