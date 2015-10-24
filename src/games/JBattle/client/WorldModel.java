package games.JBattle.client;

import framework.core.math.Vector2D;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class WorldModel {
    int[][] terrain;
    ArrayList<ClientGoldMine> goldMines;
    ClientPlayer self;
    public WorldModel() {
        goldMines=new ArrayList<>();
    }

    void setTerrain(JSONObject data)
    {
        JSONArray array = data.getJSONArray("terrain");
        int w = array.length();
        int h = array.getJSONArray(0).length();
        terrain = new int[w][h];
        for(int i = 0 ; i < w ; i++)
        {
            for(int j = 0 ; j < h ; j++)
            {
                terrain[i][j] = (int)array.getJSONArray(i).get(j);
            }
        }
    }
    void setGoldMines(JSONObject data)
    {
        JSONArray array = data.getJSONArray("objects").getJSONArray(0);
        goldMines.clear();
        for(int i=0 ; i < array.length() ; i++)
        {
            goldMines.add(new ClientGoldMine(array.getJSONObject(i)));
        }
    }
    void setSelf(JSONObject data)
    {
        self = new ClientPlayer(data);
    }
}
