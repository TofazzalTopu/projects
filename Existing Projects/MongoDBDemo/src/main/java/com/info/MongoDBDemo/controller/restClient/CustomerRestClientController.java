package com.info.MongoDBDemo.controller.restClient;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mdtofazzal.hossain on 3/28/2019.
 */

@RestController
@RequestMapping(value = "/customer")
public class CustomerRestClientController {

    private static String outPutValue;

    @RequestMapping(value = "/fetchCustomer")
    public String fetchCustomer() {
        try {
//            JSONParser parser = new JSONParser();

            URL url = new URL("http://localhost:8088/itemCatalog/customer/getCustomer");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            int responseCode = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {

                /*JSONArray a = (JSONArray) parser.parse(output);
                // Loop through each item
                for (Object o : a) {
                    JSONPObject tutorials = (JSONPObject) o;
                    String name = tutorials.get("name");
                    Long id = (Long) tutorials.get("id");
                    System.out.println("Post ID : " + id);
                }
                */
                outPutValue = output;
                System.out.println(output);
            }
            conn.disconnect();
            return outPutValue;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ParseException e) {
            e.printStackTrace();
        }*/
        return outPutValue;
    }


}
