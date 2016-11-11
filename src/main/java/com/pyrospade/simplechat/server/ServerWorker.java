package com.pyrospade.simplechat.server;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.message.MessagePool;
import com.pyrospade.simplechat.net.MessageSocket;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class ServerWorker extends Thread {

    private MessageSocket ms;
    private MessagePool mp;

    public ServerWorker(MessageSocket ms, MessagePool mp) {
        this.ms = ms;
        this.mp = mp;
    }

    public void run() {
        Message m;
        while(!(m = ms.readMessage()).getContent().equals("/dc")) mp.addMessage(m);
        close();
    }

    public void close() {
        ms.close();
    }

}
