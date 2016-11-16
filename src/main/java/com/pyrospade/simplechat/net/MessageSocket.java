package com.pyrospade.simplechat.net;

import com.pyrospade.simplechat.message.Message;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class MessageSocket {

    private UUID id;
    private Socket s;
    private BufferedReader br;
    private PrintWriter pw;

    public MessageSocket(String host, int port) {
        id = UUID.randomUUID();
        try {
            s = new Socket(host,port);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MessageSocket(Socket s, UUID id) {
        this.id = id;
        this.s = s;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message m) {
        pw.println(messageToJSON(m).toString());
    }

    public JSONObject messageToJSON(Message m) {
        return new JSONObject()
                .put("id", m.getId().toString())
                .put("timestamp", String.valueOf(m.getTimestamp()))
                .put("authorId", m.getAuthorId().toString())
                .put("authorName", m.getAuthorName())
                .put("content", m.getContent());
    }

    public Message JSONToMessage(String json) {
        JSONObject j = new JSONObject(json);
        return new Message(j.getString("content"), j.getString("authorName"), j.getLong("timestamp"));
    }

    public Message readMessage() {
        return JSONToMessage(readLine());
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "ReadError";
        }
    }

    public UUID getId() {
        return id;
    }

    public void close() {
        disconnect();
        pw.close();
        try {
            br.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        sendMessage(new Message("/dc"));
    }

}
