package framework.core.math;

import org.json.JSONObject;
import org.json.JSONString;

/**
 * Created by Pouya Payandeh on 10/16/2015.
 */
public class Vector2D implements JSONString{
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2D(int x, int y) {

        this.x = x;
        this.y = y;
    }
    public Vector2D(JSONObject data)
    {
        this.x=data.getInt("x");
        this.y=data.getInt("y");
    }
    public void add(Vector2D v)
    {
        this.x+=v.x;
        this.y+=v.y;
    }
    public int getDistance(Vector2D v)
    {
        int xx = x-v.x;
        int yy = y-v.y;
        return (int) Math.sqrt(xx*xx+yy*yy);
    }

    @Override
    public Vector2D clone()  {
        return new Vector2D(x,y);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.accumulate("x",x);
        obj.accumulate("y",y);
        return obj.toString();
    }
}
