package com.pyrospade.simplechat.client;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.net.MessageSocket;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class ServerReader extends Thread {

    private MessageSocket ms;

    public ServerReader(MessageSocket ms) {
        this.ms = ms;
    }

    public void run() {
        Message m;
        while(!(m = ms.readMessage()).getContent().equals("/dc")) System.out.println(m.getContent());
        close();
    }

    public void close() {
        ms.close();
    }

}
