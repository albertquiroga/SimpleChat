package com.pyrospade.simplechat.message;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * Created by aquirogb on 16/11/2016.
 */
public class JSONManager {

    public static JSONObject messageToJSON (Message m) {
        JSONObject jo = new JSONObject();
        for (Field f : Message.class.getDeclaredFields()) {
            try {
                jo.put(f.getName(), f.get(m).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return jo;
    }

    /*public JSONObject messageToJSON(Message m) {
        return new JSONObject()
                .put("id", m.getId().toString())
                .put("timestamp", String.valueOf(m.getTimestamp()))
                .put("authorId", m.getAuthorId().toString())
                .put("authorName", m.getAuthorName())
                .put("content", m.getContent());
    }*/

    /*public static Message JSONToMessage (String jsonStr) {
        JSONObject json = new JSONObject(jsonStr);
        for (String k : json.keySet()) {

        }
    }*/

    public static Message JSONToMessage(String json) {
        JSONObject j = new JSONObject(json);
        return new Message(j.getString("content"), j.getString("authorName"))
                .setId(UUID.fromString(j.getString("id")))
                .setAuthorId(UUID.fromString(j.getString("authorId")))
                .setTimestamp(j.getLong("timestamp"));
    }

}
