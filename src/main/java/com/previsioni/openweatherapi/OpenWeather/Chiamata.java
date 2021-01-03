package com.previsioni.openweatherapi.OpenWeather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Chiamata {

    public static void call_me() throws Exception{


        String LOCATION = Città.getNome();
        String API_KEY ="64ad2ae5de08dc46224c92d7503a2ac2";
        String LANG = "it";
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + LOCATION + "&appid=" + API_KEY + "&lang=" + LANG + "&units=metric";
        URL obj = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //optional default is GET
        con.setRequestMethod("GET");
        //add request header
        //	con.setRequestProperty(key, value);
        int responseCode= con.getResponseCode();
        System.out.println("Sending GET request to url: "+ urlString);
        System.out.println("Response Code: "+responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine= in.readLine()) !=null) {
            response.append(inputLine);
        }
        in.close();


        //read JSON response and print
        JSONObject myResponse= new JSONObject(response.toString());
        JSONObject city = myResponse.getJSONObject ("city");
        JSONArray list = myResponse.getJSONArray ("list");
        JSONObject zero = list.getJSONObject(0);
        JSONObject main = zero.getJSONObject("main");





        System.out.println("result after Reading JSON Response");
        System.out.println("città: " + city.getString("name"));
        System.out.println("temperatura - "+ main.getDouble("temp"));
        System.out.println("temperatura minima - "+ main.getDouble("temp_min"));
        System.out.println("temperatura massima - "+ main.getDouble("temp_max"));

    }


}
