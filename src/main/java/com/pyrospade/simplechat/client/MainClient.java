package com.pyrospade.simplechat.client;

import com.pyrospade.simplechat.net.MessageSocket;

/**
 * Created by pyro_ on 10/11/2016.
 */
class MainClient {

    private static final String host = "localhost";
    private static final int port = 8959;

    public static void main(String[] args) {

        MessageSocket ms = new MessageSocket(host, port);

        KeyboardReader kr = new KeyboardReader(ms);
        ServerReader sr = new ServerReader(ms);

        kr.start();
        sr.start();

        try {
            kr.join();
            sr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ms.close();

    }

}
