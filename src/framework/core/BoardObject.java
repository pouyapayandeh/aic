package framework.core;

import framework.core.math.Vector2D;

/**
 * Created by Pouya Payandeh on 10/11/2015.
 */
public abstract class BoardObject {
    Vector2D pos;

    public int getX() {
        return pos.getX();
    }

    public void setX(int x) {
        pos.setX(x);
    }

    public int getY() {
        return pos.getY();
    }

    public Vector2D getPos() {
        return pos;
    }

    public void setY(int y) {
        pos.setY(y);
    }
    public void setPosition(int x,int y){pos = new Vector2D(x,y);}
    public void setPosition(Vector2D pos){this.pos = pos;}
    public void move(Vector2D v){this.pos.add(v);}
}
