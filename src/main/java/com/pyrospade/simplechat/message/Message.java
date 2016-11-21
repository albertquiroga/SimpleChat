package com.pyrospade.simplechat.message;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
@SuppressWarnings("WeakerAccess")
public class Message {

    //All these must be protected for the JSONManager to be able to access and read them (automatic JSON construction).
    protected UUID id;
    protected String content;
    protected UUID authorId;
    protected String authorName;
    protected long timestamp;

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

    public Message setId(UUID id) {
        this.id = id;
        return this;
    }

    public Message setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public Message setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && Message.class.isInstance(obj)) return checkIfEquals((Message) obj);
        return false;
    }

    public boolean checkIfEquals(Message m) {
        return id.equals(m.getId()) && authorId.equals(m.getAuthorId()) && timestamp == m.getTimestamp() && authorName.equals(m.getAuthorName()) && content.equals(m.getContent());
    }

}
