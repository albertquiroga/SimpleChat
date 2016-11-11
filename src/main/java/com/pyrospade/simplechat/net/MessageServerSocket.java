package com.pyrospade.simplechat.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class MessageServerSocket {

    private ServerSocket ss;
    private SocketPool sp;

    public MessageServerSocket(int port) {
        this.sp = new SocketPool();
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MessageSocket accept() {
        UUID id = UUID.randomUUID();
        MessageSocket ms = null;
        try {
            ms = new MessageSocket(ss.accept(),id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sp.addSocket(ms);
        return ms;
    }

    public SocketPool getSocketPool() {
        return sp;
    }

}
