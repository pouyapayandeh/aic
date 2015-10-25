package games.JBattle.client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pouya Payandeh on 10/25/2015.
 */
public class ClientPlayer {
    int gold;
    int id;
    String name;
    ArrayList<ClientUnit> agents;
    public ClientPlayer(JSONObject data) {
        gold = data.getInt("gold");
        id = data.getInt("PlayerId");
        name = data.getString("name");
        agents = new ArrayList<>();
    }
    public void updateAgents(JSONArray array)
    {
        agents = new ArrayList<>();
        for(int i =0  ; i < array.length() ; i++)
        {
                JSONObject agent = array.getJSONObject(i);
                agents.add(new ClientUnit(agent));
        }
    }
}
