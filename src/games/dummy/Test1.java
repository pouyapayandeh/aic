package games.dummy;

import framework.core.*;
import framework.core.math.Vector2D;
import framework.graphics.JFrameWrap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pouya Payandeh on 10/11/2015.
 */
public class Test1 {
    public static void main(String[] args) {
        JFrameWrap frameWrap =new JFrameWrap();
        MapBoard b = new MapBoard("f:\\map.txt");
        b.initBoard();
        final Game g = new Game();
        g.setBoard(b);
        GamePlayer player = new GamePlayer();
        g.addPlayer(player);
        GameAgent ag = new GameAgent();
        ag.setPosition(2,2);
        g.addAgents(player,ag);
        final MoveCommand cmd = new MoveCommand(ag,new Vector2D(1,0));
        Timer timer =new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmd.doCommand(g);
            }
        });
        SimpleGameGR simpleGameGR =new SimpleGameGR(g);

        frameWrap.initUI(simpleGameGR);

        timer.start();



    }
}
