package com.pyrospade.simplechat.message;

import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class MessagePool extends Observable {

    private final ConcurrentHashMap<UUID, Message> pool;

    public MessagePool() {
        pool = new ConcurrentHashMap<>();
    }

    public void addMessage(Message m) {
        System.out.println("\t" + m.getChatLine());
        pool.put(m.getId(),m);
        setChanged();
        notifyObservers(m);
    }

    public Message getMessage(UUID id) {
        return pool.get(id);
    }

    public void deleteMessage(UUID id) {
        pool.remove(id);
    }

}
