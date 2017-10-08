package service;

import model.Event;
import org.json.JSONObject;

public class JsonObjectToEventObject {

    public static Event convert(JSONObject json){

        Event event = new Event();
        event.setType(json.get("type").toString());
        event.setAmount(json.get("amount").toString());
        event.setDate(json.get("date").toString());

        return event;
    }

}
