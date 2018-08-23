package com.example.hitesh.jsongetandclick;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ActorDataParser {

    String json;

    public String getJson(String actor_URL) {

        try {
            URL url = new URL(actor_URL);
            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
            BufferedInputStream stream =new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String aaa;
            StringBuffer buffer =new StringBuffer();

            while ((aaa =reader.readLine()) !=null){
                buffer.append(aaa);
            }

            json =buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
