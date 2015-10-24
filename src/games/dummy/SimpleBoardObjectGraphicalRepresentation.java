package games.dummy;

import framework.core.BoardObject;
import framework.core.GameAgent;
import framework.graphics.BoardObjectGraphicalRepresentation;

import java.awt.*;

/**
 * Created by Pouya Payandeh on 10/15/2015.
 */
public class SimpleBoardObjectGraphicalRepresentation extends BoardObjectGraphicalRepresentation {
    public SimpleBoardObjectGraphicalRepresentation(int tileWidth, int tileHeight) {
        super(tileWidth, tileHeight);
    }

    @Override
    public void drawAgent(GameAgent ag, Graphics2D g) {
        int x = ag.getX() * getTileWidth();
        int y = ag.getY() * getTileHeight();
        g.fillArc(x,y,getTileWidth(),getTileHeight(),0,360);
    }

    @Override
    public void drawObject(BoardObject object, Graphics2D g) {

    }
}
