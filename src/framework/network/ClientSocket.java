package framework.network;

import framework.core.GamePlayer;
import framework.network.events.DataRecievedEvent;

import java.io.*;
import java.net.Socket;
import java.util.Observable;

/**
 * Created by Pouya Payandeh on 10/22/2015.
 */
public class ClientSocket  implements  Runnable{
    Socket socket;
    Thread thread;
    DataRecievedEvent dataRecievedEvent;
    GamePlayer owner = null;

    public GamePlayer getOwner() {
        return owner;
    }

    public void setOwner(GamePlayer owner) {
        this.owner = owner;
    }

    public DataRecievedEvent getDataRecievedEvent() {
        return dataRecievedEvent;
    }

    private OutputStreamWriter osw;

    public ClientSocket() {
        thread = new Thread(this);
        dataRecievedEvent = new DataRecievedEvent();
    }

    void handelSocket(Socket socket)
    {
        this.socket = socket;
        try {
            osw = new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread.start();
    }
    public void connect(String host,int port)
    {
        try {
            socket=new Socket(host, port);
            osw = new OutputStreamWriter(socket.getOutputStream());
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Response(String s)
    {
        try {
            osw.write(s);
            osw.write("\n");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true)
            {
                String s = stream.readLine();
                Object[] args={this,s};
                dataRecievedEvent.notifyObservers(args);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
