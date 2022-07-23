package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarsRoverTask {

    private List<Point> directions = null;

    private List<String>directionsNames = null;

    private Map<String,Integer> directionsIndexes = null;

    public HashMap<Point, Integer> getObstacles() {
        return obstacles;
    }

    public void setObstacles(HashMap<Point, Integer> obstacles) {
        this.obstacles = obstacles;
    }

    private HashMap<Point,Integer>obstacles;


    public MarsRoverTask() {

        directions = List.of(
                new Point(0,1),
                new Point(1,0),
                new Point(0,-1),
                new Point(-1,0)
        );

        directionsNames = List.of(
                "North","East","South","West"
        );

        directionsIndexes = Map.of(
                "N",0,
                "E",1,
                "S",2,
                "W",3
        );
    }

    public String PartI(Point index, String path){


        path = path.toUpperCase();
        int size = path.length();
        int idx = directionsIndexes.get(index.getDirection());

        for (int i = 0; i < size; i++) {
            if(path.charAt(i) == 'R'){
                idx = ((idx + 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'L'){
                idx = ((idx - 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'F'){
                index.goFront(directions.get(idx));
            }
            else if(path.charAt(i) == 'B'){
                index.goBack(directions.get(idx));
            }
        }
        return "(" + index.getX() + "," + index.getY() + ") " + directionsNames.get(idx);
    }

    public String PartII(Point index, String path){


        Point lastPoint = new Point();
        path = path.toUpperCase();
        int size = path.length();
        int idx = directionsIndexes.get(index.getDirection());

        int i = 0;
        while(i < size && obstacles.get(index) == null){
            if(path.charAt(i) == 'R'){
                idx = ((idx + 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'L'){
                idx = ((idx - 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'F'){
                lastPoint.replacePoint(index);
                index.goFront(directions.get(idx));
            }
            else if(path.charAt(i) == 'B'){
                lastPoint.replacePoint(index);
                index.goBack(directions.get(idx));
            }
            i++;
        }


        if(obstacles.get(index) != null)
            return "(" + lastPoint.getX() + "," + lastPoint.getY() + ") " + directionsNames.get(idx) + " STOPPED";

        return "(" + index.getX() + "," + index.getY() + ") " + directionsNames.get(idx);
    }

    public String PartIII(Point index,Point endPoint){
        return "Hello There This is PartIII !!!";
    }

}
