package com.pyrospade.simplechat.server;

import com.pyrospade.simplechat.message.MessagePool;
import com.pyrospade.simplechat.net.MessageServerSocket;

/**
 * Created by pyro_ on 10/11/2016.
 */
class MainServer {

    private static final int port = 8959;

    public static void main (String[] args) {

        MessageServerSocket mss = new MessageServerSocket(port);
        MessagePool mp = new MessagePool();
        mp.addObserver(mss.getSocketPool());

        while(true) {
            new ServerWorker(mss.accept(),mp,mss.getSocketPool()).start();
        }

    }

}
