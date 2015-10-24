package games.JBattle.server.graphics;

import framework.core.GameBoard;
import framework.graphics.BoardGraphicalRepresentation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class BattleGroundGR extends BoardGraphicalRepresentation {
    BufferedImage terrain_stone,terrain_grass;
    public BattleGroundGR(GameBoard board, int tileWidth, int tileHeight) {
        super(board, tileWidth, tileHeight);
        terrain_stone = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_BGR);
        loadTexture(terrain_stone,"f:\\terrain_stone.jpg");
        terrain_grass = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_BGR);
        loadTexture(terrain_grass,"f:\\terrain_grass.jpg");

    }

    @Override
    public BufferedImage getTerrainImage() {
        BufferedImage img = new BufferedImage(board.getWidth() * getTileWidth(), board.getHeight()* getTileHeight(),BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img.createGraphics();
        int[][] terrain = board.getTerrain();
        for(int x = 0 ;  x < board.getWidth() ; x++)
            for(int  y = 0 ; y < board.getHeight() ; y++)
            {
                int totalX=x * getTileWidth();
                int totalY=y * getTileHeight();
                if(terrain[x][y] == 0) {
                    g.drawImage(terrain_grass, totalX, totalY, null);
                }
                else {
                    g.drawImage(terrain_stone, totalX, totalY, null);
                }
            }
        return img;
    }
}
