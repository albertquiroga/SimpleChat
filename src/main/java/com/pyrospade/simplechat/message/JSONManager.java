package com.pyrospade.simplechat.message;

import org.json.JSONObject;

import java.lang.reflect.Field;

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

    /*public static Message JSONToMessage (String jsonStr) {
        JSONObject json = new JSONObject(jsonStr);
        for (String k : json.keySet()) {

        }
    }*/

}
