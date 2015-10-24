package games.dummy;

import framework.core.GameBoard;
import framework.graphics.BoardGraphicalRepresentation;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pouya Payandeh on 10/11/2015.
 */
public class SimpleBoardGraphicalRepresentation extends BoardGraphicalRepresentation {
    public SimpleBoardGraphicalRepresentation(GameBoard board, int tileWidth, int tileHeight) {
        super(board, tileWidth, tileHeight);
    }

    @Override
    public BufferedImage getTerrainImage() {
        BufferedImage img = new BufferedImage(board.getWidth() * getTileWidth(), board.getHeight()* getTileHeight(),BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img.createGraphics();
        int[][] terrain = board.getTerrain();
        for(int x = 0 ;  x < board.getWidth() ; x++)
            for(int  y = 0 ; y < board.getHeight() ; y++)
            {
                if(terrain[x][y] == 0)
                    g.setColor(Color.black);
                else
                    g.setColor(Color.BLUE);
                g.fillRect(x* getTileWidth(), y* getTileHeight(), getTileWidth(), getTileHeight());
            }
        return img;
    }
}
