package com.pyrospade.simplechat.net;

import com.pyrospade.simplechat.message.Message;

import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class SocketPool implements Observer {

    private ConcurrentHashMap<UUID,MessageSocket> pool;

    public SocketPool() {
        pool = new ConcurrentHashMap<UUID, MessageSocket>();
    }

    public void addSocket(MessageSocket s) {
        System.out.println("New connection from " + s.getId());
        pool.put(s.getId(),s);
    }

    public MessageSocket getSocket(UUID id) {
        return pool.get(id);
    }

    public void removeSocket(UUID id) {
        pool.remove(id);
    }

    public void sendBroadcastMessage(Message m) {
        for(UUID key : pool.keySet()) if (m.getId().compareTo(key) != 0) pool.get(key).sendMessage(m);
    }

    public void update(Observable o, Object arg) {
        sendBroadcastMessage((Message) arg);
    }

}
