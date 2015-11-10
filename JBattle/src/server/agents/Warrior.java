package server.agents;

import core.GameAgent;
import core.math.Vector2D;
import server.Settings;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class Warrior extends Unit {
    public Warrior(Vector2D pos) {
        super(pos,"WARRIOR", Settings.WarrioHP,Settings.WarriorATK);
    }
}
