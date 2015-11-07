package server.agents;

import core.GameAgent;
import server.Settings;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class Warrior extends Unit {
    public Warrior() {
        super("WARRIOR", Settings.WarrioHP,Settings.WarriorATK);
    }
}
