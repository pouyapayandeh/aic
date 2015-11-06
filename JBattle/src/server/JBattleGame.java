package server;

import core.GamePlayer;
import core.TurnBaseGame;
import core.math.Vector2D;
import server.agents.Castle;
import server.objects.GoldMine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class JBattleGame extends TurnBaseGame{
    int cp =0;
    int maxPlayer;
    ArrayList<Vector2D> playerLoc;
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
        for (int i = 0; i < maxPlayer; i++)
        {
            Castle castle = new Castle();
            castle.setPosition(playerLoc.get(i));
            addAgents(players.get(i),castle);
        }
        started=true;
        super.start();
    }
    public void loadPositionFile(String path)
    {
        File mapfile = new File(path);
        if(mapfile.exists())
        {
            try {
                Scanner reader = new Scanner(mapfile);
                int goldNum , playerNum;
                goldNum = reader.nextInt();
                playerNum = reader.nextInt();
                maxPlayer = playerNum;
                for(int i = 0 ;  i < goldNum ; i++)
                {
                    int goldAmount,goldX,goldY;
                    goldX = reader.nextInt();
                    goldY = reader.nextInt();
                    goldAmount= reader.nextInt();
                    objects.add(new GoldMine(goldAmount,goldX,goldY));
                }
                playerLoc = new ArrayList<>();
                for(int i = 0 ;  i < playerNum ; i++)
                {
                    int playerX,playerY;
                    playerX = reader.nextInt();
                    playerY = reader.nextInt();
                    playerLoc.add(new Vector2D(playerX,playerY));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void doTurn()
    {
        cp=(cp+1)%maxPlayer;
    }
}
