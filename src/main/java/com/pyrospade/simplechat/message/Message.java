package com.pyrospade.simplechat.message;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
@SuppressWarnings("WeakerAccess")
public class Message {

    //All these must be protected for the JSONManager to be able to access and read them (automatic JSON construction).
    protected final UUID id;
    protected final String content;
    protected UUID authorId;
    protected final String authorName;
    protected final long timestamp;

    public Message(String content, String authorName) {
        this.id = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis();
        this.authorId = UUID.randomUUID();
        this.authorName = authorName;
        this.content = content;
    }

    public Message setAuthorId(UUID id){
        this.authorId = id;
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
