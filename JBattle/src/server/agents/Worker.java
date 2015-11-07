package server.agents;

import core.GameAgent;
import server.Settings;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class Worker extends Unit {
    public Worker() {
        super("WORKER", Settings.WorkerHP,Settings.WarriorATK);
    }
}
