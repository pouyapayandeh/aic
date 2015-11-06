package client;

import core.math.Vector2D;
import json.JSONObject;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientGoldMine {
    Vector2D pos;
    int goldAmount;

    public ClientGoldMine(Vector2D pos, int goldAmount) {
        this.pos = pos;
        this.goldAmount = goldAmount;
    }
    public ClientGoldMine(JSONObject data)
    {
        goldAmount = (int) data.get("goldamount");
        pos = new Vector2D((Integer) data.getJSONObject("pos").get("x"),(Integer) data.getJSONObject("pos").get("y"));
    }
}
