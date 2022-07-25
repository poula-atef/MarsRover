package com.example;

import java.util.*;

public class MarsRoverTask {

    private final List<String> directionsSymbols;
    private final List<Point> directions;

    private final List<String>directionsNames;

    private final Map<String,Integer> directionsIndexes;

    private HashMap<Point,Integer>obstacles;

    public void setObstacles(HashMap<Point, Integer> obstacles) {
        this.obstacles = obstacles;
    }

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

        directionsSymbols = List.of(
                "N",
                "E",
                "S",
                "W"
        );
    }

    public String PartI(Point startPoint, String path){


        path = path.toUpperCase();
        int size = path.length();
        int idx = directionsIndexes.get(startPoint.getDirection());

        for (int i = 0; i < size; i++) {
            if(path.charAt(i) == 'R'){
                idx = ((idx + 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'L'){
                idx = ((idx - 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'F'){
                startPoint.goFront(directions.get(idx));
            }
            else if(path.charAt(i) == 'B'){
                startPoint.goBack(directions.get(idx));
            }
        }
        return "(" + startPoint.getX() + "," + startPoint.getY() + ") " + directionsNames.get(idx);
    }

    public String PartII(Point startPoint, String path){


        Point lastPoint = new Point();
        path = path.toUpperCase();
        int size = path.length();
        int idx = directionsIndexes.get(startPoint.getDirection());

        int i = 0;
        while(i < size && obstacles.get(startPoint) == null){
            if(path.charAt(i) == 'R'){
                idx = ((idx + 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'L'){
                idx = ((idx - 1) + 4) % 4;
            }
            else if(path.charAt(i) == 'F'){
                lastPoint.replacePoint(startPoint);
                startPoint.goFront(directions.get(idx));
            }
            else if(path.charAt(i) == 'B'){
                lastPoint.replacePoint(startPoint);
                startPoint.goBack(directions.get(idx));
            }
            i++;
        }


        if(obstacles.get(startPoint) != null)
            return "(" + lastPoint.getX() + "," + lastPoint.getY() + ") " + directionsNames.get(idx) + " STOPPED";

        return "(" + startPoint.getX() + "," + startPoint.getY() + ") " + directionsNames.get(idx);
    }

    //Implemented using BFS
    public String PartIII(Point startPoint,Point endPoint){

        Queue<Node> q = new LinkedList<>();
        Map<Node,Integer>visited = new HashMap<>();
        int directionIndex;
        Point directionValue;
        String pointDirection;

        Node parent = new Node();
        parent.setPoint(startPoint);
        q.add(parent);


        while(q.size() > 0){

            parent= q.poll();
            visited.put(parent,1);

            if(parent.getPoint().getX() == endPoint.getX() && parent.getPoint().getY() == endPoint.getY())
                break;
            if(obstacles.get(parent.getPoint()) != null)
                continue;


            // Adding the Forward point of the parent to the queue
            Node node = new Node(parent);

            directionIndex = directionsIndexes.get(node.getPointDirection());
            directionValue = directions.get(directionIndex);
            node.goFront(directionValue);
            node.setParent(parent);
            node.setNodeDirection("F");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);
            ////////////////////////////////////////////////////////////////////////////////


            // Adding the Right Directed point of the parent to the queue
            node = new Node(parent);
            directionIndex = (directionsIndexes.get(node.getPointDirection()) + 1) % 4;
            pointDirection = directionsSymbols.get(directionIndex);
            node.setPointDirection(pointDirection);
            node.setParent(parent);
            node.setNodeDirection("R");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);
            ////////////////////////////////////////////////////////////////////////////////


            // Adding the Left Directed point of the parent to the queue
            node = new Node(parent);
            directionIndex = (directionsIndexes.get(node.getPointDirection()) - 1 + 4) % 4;
            pointDirection = directionsSymbols.get(directionIndex);
            node.setPointDirection(pointDirection);
            node.setParent(parent);
            node.setParent(parent);
            node.setNodeDirection("L");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);
            ////////////////////////////////////////////////////////////////////////////////

        }

        // Extracting the path from the final node
        StringBuilder builder = new StringBuilder();
        while(parent.getParent() != null){
            builder.append(parent.getNodeDirection());
            parent = parent.getParent();
        }
        /////////////////////////////////////////////////////

        return builder.reverse().toString();
    }

}
