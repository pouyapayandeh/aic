package server.agents;

import core.GameAgent;
import core.math.Vector2D;
import json.JSONObject;
import json.JSONString;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class Unit extends GameAgent implements JSONString {
    public int HP;
    public int ATK;
    public int movePerTurn;

    public String getType() {
        return type;
    }

    protected final String type;

    public Unit(String type) {
        this.type=type;
    }

    public Unit(Vector2D pos ,String type, int HP, int ATK) {
        setPosition(pos.clone());
        this.type=type;
        this.HP = HP;
        this.ATK = ATK;
    }

    public String toJSONString()
    {
        JSONObject obj = new JSONObject();
        obj.accumulate("type", this.type);
        obj.accumulate("id",agentId);
        obj.accumulate("owner",getOwner().getPlayerId());
        obj.accumulate("pos", this.getPos());
        obj.accumulate("HP",HP);
        obj.accumulate("ATK", ATK);
        return  obj.toString();
    }
}
