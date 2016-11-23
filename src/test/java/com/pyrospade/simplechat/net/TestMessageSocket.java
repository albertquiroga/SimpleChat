package com.pyrospade.simplechat.net;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.server.MainServer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aquirogb on 23/11/2016.
 */
public class TestMessageSocket {

    private static final String host = "localhost";
    private static final int port = 8959;

    @BeforeClass
    public static void setEnvironment() {
        new Thread() {
            public void run() {
                new MainServer().main(new String[0]);
            }
        }.start();
    }

    @Test
    public void testSendMessage() {
        MessageSocket ms = new MessageSocket(host, port);
        Message m = new Message("test", "testAuthor");

        assertTrue("Send message", ms.sendMessage(m));
    }



}
