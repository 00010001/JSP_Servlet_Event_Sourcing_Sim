package service;

import config.URLConfig;
import model.Event;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import static service.JsonReader.readJsonFromUrl;

public class FinalServerUtil {

    private static LinkedList<Event> eventLinkedList = new LinkedList<>();

    public static LinkedList<Event> getEventLinkedList() {
        return eventLinkedList;
    }

    public static void getEventFromQueueServer() {
        if (FinalServerUtil.canFetchFromQueueServer()) {

            JSONObject json = new JSONObject();
            try {
                json = readJsonFromUrl(URLConfig.LOCALHOST + "/queueSendEvent");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Event event = JsonObjectToEventObject.convert(json);
            eventLinkedList.add(event);
        } else {
            System.out.println("no events on queue server");
        }
    }

    public static int getNumberOfEventsInQueue() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URLConfig.LOCALHOST + "/queueSendQueueSize");
        HttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Header header = response.getLastHeader("queueSize");
        return Integer.parseInt(header.getValue());
    }

    public static int getNumberOfEventsOnServer() {
        return eventLinkedList.size();
    }

    public static void getAllEventsFromQueue(int queueSize) {
        if (FinalServerUtil.canFetchFromQueueServer()) {

            for (int i = 0; i < queueSize; i++) {
                getEventFromQueueServer();
            }
        } else {
            System.out.println("no events on queue server");

        }
    }

    public static void saveEventsToFile() {
        if (getNumberOfEventsOnServer() > 0) {
            String userHomeFolder = System.getProperty("user.home");
            File textFile = new File(userHomeFolder, "output.txt");
            FileWriter writer = null;
            try {
                writer = new FileWriter(textFile);
                for (Event event : eventLinkedList) {
                    writer.write(event.toString());
                    writer.write(System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean canFetchFromQueueServer() {
        if (getNumberOfEventsInQueue() > 0) {
            return true;
        }
        return false;
    }
}
