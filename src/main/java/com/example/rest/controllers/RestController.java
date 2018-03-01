package com.example.rest.controllers;

import com.example.rest.model.AreaWisePopulation;
import com.example.rest.model.Population;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by Balaji on 1/3/18.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController{
    @GetMapping("/")
    public String hi(){
        return "hi";
    }
    @RequestMapping("/population")
    public ResponseEntity<AreaWisePopulation> connectToApi() throws IOException {
        /*RestTemplate template = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON));
        template.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        AreaWisePopulation population = template.getForObject(
                "https://api.data.gov.in/resource/563cf530-fa3c-4a56-807f-b6783f2de10f?format=json&api-key=579b464db66ec23bdd00000158ed2474afcc4e5e59198bdf1341621f",
                AreaWisePopulation.class);
        System.out.println("Population : "+population);*/
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString =connection();
        AreaWisePopulation areaWisePopulation =mapper.readValue(jsonInString, AreaWisePopulation.class);
        System.out.println(areaWisePopulation);
        return ResponseEntity.ok(areaWisePopulation);
    }

    public String connection() {
        String json = null;
        try {

            URL url = new URL("https://api.data.gov.in/resource/563cf530-fa3c-4a56-807f-b6783f2de10f?format=json&api-key=579b464db66ec23bdd00000158ed2474afcc4e5e59198bdf1341621f");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            json = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                json += output;
            }
            conn.disconnect();
            return json;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return  json;
        }
    }
}
