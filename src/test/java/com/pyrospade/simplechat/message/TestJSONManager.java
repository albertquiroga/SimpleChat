package com.pyrospade.simplechat.message;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by aquirogb on 21/11/2016.
 */
public class TestJSONManager {

    private static UUID id1;
    private static UUID id2;
    private static long timestamp;
    private static String authorName;
    private static String content;

    @BeforeClass
    public static void setup() {
        id1 = UUID.randomUUID();
        id2 = UUID.randomUUID();
        timestamp = System.currentTimeMillis();
        authorName = "mark";
        content = "hello, world!";
    }

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
