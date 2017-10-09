package service;

import config.URLConfig;
import model.Event;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QueueServer {
    private static LinkedList<Event> eventLinkedList = new LinkedList<>();
    private static List<String> serversURLList = new ArrayList<String>() {{
        add(URLConfig.LOCALHOST+"/finalServerReceiver");
    }};

    public static LinkedList<Event> getEventLinkedList(){
        return eventLinkedList;
    }

    public static List<String> getServersURLList(){
        return serversURLList;
    }

    public static int getNumberOfEventsInQueue(){
        return eventLinkedList.size();
    }

    public static void addServerURL(String url) {
        serversURLList.add(url);
    }

    public static void addEventToQueue(Event event) {
        eventLinkedList.add(event);
    }

    public static JSONObject getFirstEventAsJsonObjectAndRemoveItAfter(){
        Event event = eventLinkedList.getFirst();
        JSONObject json = new JSONObject();
        json.put("type", event.getType());
        json.put("amount", event.getAmount());
        json.put("date", event.getDate());
        eventLinkedList.removeFirst();
        return json;
    }








}
