package server.agents;

import core.GameAgent;
import json.JSONObject;
import json.JSONString;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class Unit extends GameAgent implements JSONString {
    protected int HP;
    protected int ATK;
    protected int movePerTurn;

    public String getType() {
        return type;
    }

    protected final String type;

    public Unit(String type) {
        this.type=type;
    }

    public int getMovePerTurn() {
        return movePerTurn;
    }

    public int getATK() {
        return ATK;
    }

    public int getHP() {
        return HP;
    }

    public boolean isMovable() {
        return movePerTurn != 0;
    }
    public String toJSONString()
    {
        JSONObject obj = new JSONObject();
        obj.accumulate("type", this.type);
        obj.accumulate("id",agentId);
        obj.accumulate("owner",getOwner().getPlayerId());
        obj.accumulate("pos", this.getPos());
        obj.accumulate("HP", this.getHP());
        obj.accumulate("ATK", this.getHP());
        return  obj.toString();
    }
}
