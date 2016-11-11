package com.pyrospade.simplechat.message;

import java.util.Date;
import java.util.UUID;

/**
 * Created by pyro_ on 10/11/2016.
 */
public class Message {

    private UUID id;
    private String content;
    private UUID authorId;
    private String authorName;
    private Date date;

    public Message(String content) {
        this.content = content;
        this.id = UUID.randomUUID();
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

}
