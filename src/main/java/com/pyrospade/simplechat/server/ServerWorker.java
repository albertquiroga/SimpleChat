package com.pyrospade.simplechat.server;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.message.MessagePool;
import com.pyrospade.simplechat.net.MessageSocket;
import com.pyrospade.simplechat.net.SocketPool;

/**
 * Created by pyro_ on 10/11/2016.
 */
class ServerWorker extends Thread {

    private final MessageSocket ms;
    private final MessagePool mp;
    private final SocketPool sp;

    ServerWorker(MessageSocket ms, MessagePool mp, SocketPool sp) {
        this.ms = ms;
        this.mp = mp;
        this.sp = sp;
    }

    public void run() {
        Message m;
        while(!(m = ms.readMessage()).getContent().equals("/dc")) mp.addMessage(m);
        close();
    }

    private void close() {
        disconnect();
        ms.close();
    }

    private void disconnect() {
        ms.sendMessage(new Message("/dc","server"));
        sp.removeSocket(ms.getId());
    }

}
