package com.example;

import java.util.*;

public class MarsRoverTask {

    private final List<String> directionsSymbols;
    private final List<Point> directions;

    private final List<String>directionsNames;

    private final Map<String,Integer> directionsIndexes;

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

        directionsSymbols = List.of(
                "N",
                "E",
                "S",
                "W"
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

        Queue<Node> q = new LinkedList<>();
        Map<Node,Integer>visited = new HashMap<>();

        Node parent = new Node();
        parent.setPoint(index);
        q.add(parent);

        while(q.size() > 0){

            parent= q.poll();
            visited.put(parent,1);

            if(parent.getPoint().getX() == endPoint.getX() && parent.getPoint().getY() == endPoint.getY())
                break;
            if(obstacles.get(parent.getPoint()) != null)
                continue;


            Node node = new Node(parent);
            node.goFront(
                    directions.get(
                            directionsIndexes.get(
                                    node.getPointDirection()
                            )
                    )
            );
            node.setParent(parent);
            node.setNodeDirection("F");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);





            node = new Node(parent);
            node.setPointDirection(
                    directionsSymbols.get(
                            (
                                    directionsIndexes.get(
                                            node.getPointDirection()
                                    ) + 1
                            ) % 4
                    )
            );
            node.setParent(parent);
            node.setNodeDirection("R");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);




            node = new Node(parent);
            node.setPointDirection(
                    directionsSymbols.get(
                            (
                                    directionsIndexes.get(
                                            node.getPointDirection()
                                    ) - 1 + 4
                            ) % 4
                    )
            );
            node.setParent(parent);
            node.setNodeDirection("L");
            if(visited.get(node) == null && obstacles.get(node.getPoint()) == null)
                q.add(node);

        }
        StringBuilder builder = new StringBuilder();

        while(parent.getParent() != null){
            builder.append(parent.getNodeDirection());
            parent = parent.getParent();
        }

//        int size = builder.length();

//        for (int i = 0; i < size - 1; i++) {
//            if(builder.charAt(i) == builder.charAt(i + 1))
//                builder.setCharAt(i,'F');
//        }

//        builder.deleteCharAt(builder.length() - 1);

        return builder.reverse().toString();
    }

}
