package games.JBattle.client;

import framework.core.math.Vector2D;
import org.json.JSONObject;

/**
 * Created by Pouya Payandeh on 10/25/2015.
 */
public class ClientUnit {
    String type;
    int id;
    int owner;
    Vector2D pos;
    int HP;
    int ATK;

    public ClientUnit(JSONObject data) {
        type=data.getString("type");
        id=data.getInt("id");
        owner = data.getInt("owner");
        pos= new Vector2D(data.getJSONObject("pos"));
        HP=data.getInt("HP");
        ATK = data.getInt("ATK");
    }
}
