package com.pyrospade.simplechat.client;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.net.MessageSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Timestamp;

/**
 * Created by pyro_ on 10/11/2016.
 */
class KeyboardReader extends Thread {

    private BufferedReader keyboard;
    private MessageSocket ms;

    private String authorName;

    KeyboardReader(MessageSocket ms) {
        this.ms = ms;
        keyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        fetchUserData();
        String line;
        while(!(line = readLine()).equals("/dc")) ms.sendMessage(new Message(line,authorName,System.currentTimeMillis()));
        ms.sendMessage(new Message("/dc"));
        close();
    }

    private String readLine() {
        try {
            return keyboard.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "KeyboardError";
        }
    }

    private void close() {
        try {
            keyboard.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fetchUserData() {
        System.out.print("username> ");
        authorName = readLine();
    }

}
