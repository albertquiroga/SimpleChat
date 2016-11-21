package com.pyrospade.simplechat.message;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by aquirogb on 21/11/2016.
 */
public class TestJSONManager {

    private final static UUID id1 = UUID.randomUUID();
    private final static UUID id2 = UUID.randomUUID();
    private final static long timestamp = System.currentTimeMillis();
    private final static String authorName = "mark";
    private final static String content = "hello, world!";

    @Test
    public void testMessageFromJSON() {
        Message m = new Message(content, authorName).setId(id1).setAuthorId(id2).setTimestamp(timestamp);
        String mJSON = "{\"authorName\":\"" + authorName + "\",\"id\":\"" + id1.toString() + "\",\"authorId\":\"" + id2.toString() + "\",\"content\":\"" + content + "\",\"timestamp\":\"" + String.valueOf(timestamp) + "\"}";

        assertEquals("Testing JSON to Message construction", m, JSONManager.JSONToMessage(mJSON));
    }

    @Test
    public void testMessageToJSON() {
        Message m = new Message(content, authorName).setId(id1).setAuthorId(id2).setTimestamp(timestamp);
        String mJSON = "{\"authorName\":\"" + authorName + "\",\"id\":\"" + id1.toString() + "\",\"authorId\":\"" + id2.toString() + "\",\"content\":\"" + content + "\",\"timestamp\":\"" + String.valueOf(timestamp) + "\"}";

        assertEquals("Testing Message to JSON conversion", mJSON, JSONManager.messageToJSON(m).toString());
    }

}
