package server;

import core.Game;
import core.MapBoard;
import graphics.JFrameWrap;
import network.GameServer;
import server.graphics.JBattleGR;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ServerMain {
    public static void main(String[] args) {
        JFrameWrap frameWrap =new JFrameWrap();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("JBATTLE MAP FILE(*.map)","map"));
        if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
        {
            String path = jFileChooser.getSelectedFile().getPath();
            System.out.println(path);
            MapBoard b = new MapBoard(path);
            b.initBoard();
            JBattleGame g = new JBattleGame();
            g.loadPositionFile(path);
            g.setBoard(b);
            JBattleGR jBattleGR = new JBattleGR(g);
            frameWrap.initUI(jBattleGR);
            GameServer server = new GameServer(1111);
            NetworkHandler networkHandler = new NetworkHandler(g, server);
            server.startServer();
        }
    }
}
