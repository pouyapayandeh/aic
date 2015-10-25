package games.JBattle.server.graphics;

import framework.core.BoardObject;
import framework.core.GameAgent;
import framework.graphics.BoardObjectGraphicalRepresentation;
import games.JBattle.server.objects.GoldMine;
import games.JBattle.server.agents.Warrior;
import games.JBattle.server.agents.Worker;

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
        loadTexture(texture_castle[0], "/textures/JBattle/castle_0.png");
        texture_castle[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_castle[1], "/textures/JBattle/castle_1.png");

        texture_warrior[0] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_warrior[0], "/textures/JBattle/warrior_0.png");
        texture_warrior[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_warrior[1], "/textures/JBattle/warrior_1.png");

        texture_worker[0] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_worker[0], "/textures/JBattle/worker_0.png");

        texture_worker[1] = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_worker[1], "/textures/JBattle/worker_1.png");

        loadTexture(texture_gold, "/textures/JBattle/texture_gold.png");
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
