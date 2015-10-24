package framework.network.events;

import framework.network.ClientSocket;

import java.util.Observable;

/**
 * Created by Pouya Payandeh on 10/24/2015.
 */
public class ClientConnectEvent extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
    
}
