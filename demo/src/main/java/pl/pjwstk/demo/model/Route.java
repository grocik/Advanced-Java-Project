package pl.pjwstk.demo.model;

import java.util.ArrayList;

public class Route {
    public Bounds bounds;
    public String copyrights;
    public ArrayList<Leg> legs;
    public OverviewPolyline overview_polyline;
    public String summary;
    public ArrayList<Object> warnings;

    public ArrayList<Integer> getWaypoint_order() {
        return waypoint_order;
    }

    public ArrayList<Integer> waypoint_order;


}
