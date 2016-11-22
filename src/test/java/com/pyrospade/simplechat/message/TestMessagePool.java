package com.pyrospade.simplechat.message;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by aquirogb on 22/11/2016.
 */
public class TestMessagePool {

    private static Message m;
    private static MessagePool mp;

    @BeforeClass
    public static void setup() {
        m = new Message("hello", "mark");
        mp = new MessagePool();
    }

    @Test
    public void testAddMessage() {
        UUID id = m.getId();
        mp.addMessage(m);
        assertEquals(m, mp.getMessage(id));
    }

    @Test
    public void testAddMessageAmount() {
        mp.addMessage(m);
        assertEquals(1, mp.getSize());
    }

    @Test
    public void testDeleteMessage() {
        UUID id = m.getId();
        mp.addMessage(m);
        Message mes = null;
        mp.deleteMessage(id);
        mes = mp.getMessage(id);
        assertNull(mes);
    }

    @Test
    public void testDeleteMessageAmount() {
        UUID id = m.getId();
        mp.addMessage(m);
        mp.deleteMessage(id);
        assertEquals(0, mp.getSize());
    }

}
