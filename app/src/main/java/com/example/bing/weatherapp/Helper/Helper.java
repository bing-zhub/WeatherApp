package com.example.bing.weatherapp.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    static String stream = null;

    public Helper(){

    }

    public String getHttpData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int code = httpURLConnection.getResponseCode();
            if(httpURLConnection.getResponseCode() == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line=bufferedReader.readLine())!=null)
                    stringBuilder.append(line);
                stream = stringBuilder.toString();
                httpURLConnection.disconnect();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

}
