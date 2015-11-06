package server.graphics;

import core.BoardObject;
import core.GameAgent;
import graphics.BoardObjectGraphicalRepresentation;
import server.objects.GoldMine;
import server.agents.Warrior;
import server.agents.Worker;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class UnitGR extends BoardObjectGraphicalRepresentation {
    private  BufferedImage texture_gold;
    private BufferedImage[] texture_castle, texture_warrior, texture_worker;
    public UnitGR(int tileWidth, int tileHeight) {
        super(tileWidth, tileHeight);
        texture_gold= new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        texture_castle = new BufferedImage[2];
        texture_warrior = new BufferedImage[2];
        texture_worker = new BufferedImage[2];
        texture_castle[0] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_castle[0], "castle_0.png");
        texture_castle[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_castle[1], "castle_1.png");

        texture_warrior[0] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_warrior[0], "warrior_0.png");
        texture_warrior[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_warrior[1], "warrior_1.png");

        texture_worker[0] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_worker[0], "worker_0.png");

        texture_worker[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_worker[1], "worker_1.png");

        loadTexture(texture_gold, "texture_gold.png");
    }

    @Override
    public void drawAgent(GameAgent ag, Graphics2D g) {
        int  x = ag.getX() * tileWidth;
        int  y = ag.getY() * tileHeight;
        BufferedImage image = null;
        if((ag instanceof Warrior))
        {
            image=texture_warrior[ag.getOwner().getPlayerId()];
        }else if (ag instanceof Worker)
        {
            image=texture_worker[ag.getOwner().getPlayerId()];
        }else
        {
            image=texture_castle[ag.getOwner().getPlayerId()];
        }
        g.drawImage(image,x,y,null);
    }

    @Override
    public void drawObject(BoardObject object, Graphics2D g) {
        int  x = object.getX() * tileWidth;
        int  y = object.getY() * tileHeight;
        if(object instanceof GoldMine)
            g.drawImage(texture_gold,x,y,null);
    }
}
