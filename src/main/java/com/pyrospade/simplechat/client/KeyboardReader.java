package com.pyrospade.simplechat.client;

import com.pyrospade.simplechat.message.Message;
import com.pyrospade.simplechat.net.MessageSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pyro_ on 10/11/2016.
 */
class KeyboardReader extends Thread {

    private BufferedReader keyboard;
    private MessageSocket ms;

    KeyboardReader(MessageSocket ms) {
        this.ms = ms;
        keyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String line;
        while(!(line = readLine()).equals("/dc")) ms.sendMessage(new Message(line));
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

}
