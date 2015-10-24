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
    private final BufferedImage texture_gold;

    public UnitGR(int tileWidth, int tileHeight) {
        super(tileWidth, tileHeight);
        texture_gold= new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_ARGB);
        loadTexture(texture_gold,"f:\\texture_gold.png");
    }

    @Override
    public void drawAgent(GameAgent ag, Graphics2D g) {
        Color tc = g.getColor();
        int  x = ag.getX() * tileWidth;
        int  y = ag.getY() * tileHeight;
        if((ag instanceof Warrior))
        {
            g.setColor(Color.RED);
        }else if (ag instanceof Worker)
        {
            g.setColor(Color.green);
        }else
        {
            g.setColor(Color.ORANGE);
        }
        g.fillArc(x,y,tileWidth,tileHeight,0,360);
        g.setColor(tc);
    }

    @Override
    public void drawObject(BoardObject object, Graphics2D g) {
        int  x = object.getX() * tileWidth;
        int  y = object.getY() * tileHeight;
        if(object instanceof GoldMine)
            g.drawImage(texture_gold,x,y,null);
    }
}
