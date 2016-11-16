package com.pyrospade.simplechat.message;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class Message {

    private UUID id;
    private String content;
    private UUID authorId;
    private String authorName;
    private long timestamp;

    public Message(String content, String authorName, Long timestamp) {
        this.id = UUID.randomUUID();
        this.timestamp = timestamp; //TODO currentTimeMillis here
        this.authorId = UUID.randomUUID();
        this.authorName = authorName;
        this.content = content;
    }

    public Message(String content) {
        //TODO Delete this constructor!!
        this.id = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis();
        this.authorId = UUID.randomUUID();
        this.authorName = "";
        this.content = content;
    }

    public Message setAuthorId(UUID id){
        this.id = id;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getChatLine() {
        return "[" + new Timestamp(timestamp).toString() + "] " + authorName + "> " + content;
    }

}
