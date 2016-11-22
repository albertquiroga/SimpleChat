package com.pyrospade.simplechat.net;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.message.MessagePool;
import com.pyrospade.simplechat.server.ServerWorker;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * Created by aquirogb on 21/11/2016.
 */
public class TestServer {

    @Test
    public void testServer() {
        fail("Not yet finished");

        final MessageServerSocket mss = new MessageServerSocket(8959);
        final MessagePool mp = new MessagePool();
        mp.addObserver(mss.getSocketPool());

        Thread sw = new Thread(){
            public void run() {
                new ServerWorker(mss.accept(),mp,mss.getSocketPool()).start();
            }
        };

        Thread client = new Thread() {
            public void run() {
                MessageSocket ms = new MessageSocket("localhost", 8959);
                ms.sendMessage(new Message("hello","testAuthor"));
                ms.readMessage();
            }
        };

    }

}
