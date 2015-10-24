package games.JBattle.server.objects;

import framework.core.BoardObject;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class GoldMine extends BoardObject {
    int GoldAmount ;

    public GoldMine(int goldAmount,int x,int y) {
        setPosition(x,y);
        GoldAmount = goldAmount;
    }
}
