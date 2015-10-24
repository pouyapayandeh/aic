package games.JBattle.client;

import org.json.JSONObject;

/**
 * Created by Pouya Payandeh on 10/25/2015.
 */
public class ClientPlayer {
    int gold;
    int id;
    String name;

    public ClientPlayer(JSONObject data) {
        gold = data.getInt("gold");
        id = data.getInt("PlayerId");
        name = data.getString("name");
    }
}
