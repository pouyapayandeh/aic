package client.commands;

import core.math.Vector2D;
import json.JSONObject;
import json.JSONString;

/**
 * Created by Pouya Payandeh on 10/25/2015.
 */
public class MoveCommand implements Command{
    int id;
    Vector2D pos;

    public MoveCommand(int id, Vector2D pos) {
        this.id = id;
        this.pos = pos;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("cmd","move");
        obj.put("id",id);
        obj.put("pos",pos);
        return obj.toString();
    }
}
