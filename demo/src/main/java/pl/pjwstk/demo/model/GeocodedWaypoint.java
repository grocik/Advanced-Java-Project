package pl.pjwstk.demo.model;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class GeocodedWaypoint{
    public String geocoder_status;
    public String place_id;
    public ArrayList<String> types;
}

