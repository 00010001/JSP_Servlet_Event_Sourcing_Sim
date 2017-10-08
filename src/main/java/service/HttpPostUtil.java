package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HttpPostUtil {

    public static int SendEventByHttpPost(String type, String amount, String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("type", type));
        arguments.add(new BasicNameValuePair("amount", amount));
        arguments.add(new BasicNameValuePair("date", dtf.format(now)));

        return executePOST(client,post,arguments);
    }

    public static int SendNumberOfEventsInQueue(String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("eventsInQueue", QueueServer.getNumberOfEventsInQueue()+""));

        return executePOST(client,post,arguments);
    }

    private static int executePOST(HttpClient client, HttpPost post, List<NameValuePair> arguments){
        int code = 0;
        try {
            post.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse response = client.execute(post);
            code = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }
}
