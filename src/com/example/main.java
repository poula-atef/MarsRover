package com.example;


import java.util.*;
import com.example.Point;

public class main {
    // E
    // 4 2
    //  FLFFFRFLB

    public static void main(String[] args) {

        MarsRoverTask task = new MarsRoverTask();
        Scanner scan = new Scanner(System.in);
        Point startPoint = new Point();
        String path;

        System.out.println("Hello There, Our Rover Just Landed on Mars,");
        System.out.println("Now .. initialize it with its starting coordinates: ");

        System.out.print("Starting X: ");
        startPoint.setX(scan.nextInt());
        System.out.print("Starting Y: ");
        startPoint.setY(scan.nextInt());
        System.out.print("Starting Direction: ");
        startPoint.setDirection(scan.next());

        while(true){

            System.out.println("");
            System.out.println("Choose your mission:");
            System.out.println("1- Mission I (PartI)");
            System.out.println("2- Mission II (PartII)");
            System.out.println("3- Mission III (PartIII)");
            System.out.println("4- Exit");
            System.out.print("Choice: ");
            int partNumber = scan.nextInt();

            switch (partNumber) {
                case 1 -> {
                    System.out.print("Path: ");
                    path = scan.next();
                    System.out.println("Result: " + task.PartI(startPoint, path));
                }
                case 2 -> {

                    System.out.print("Path: ");
                    path = scan.next();
                    System.out.print("Obstacles : ");
                    int size = scan.nextInt();
                    int obstacleX, obstacleY;
                    HashMap<Point, Integer> obstacles = new HashMap<>();
                    for (int i = 0; i < size; i++) {
                        obstacleX = scan.nextInt();
                        obstacleY = scan.nextInt();
                        obstacles.put(new Point(obstacleX, obstacleY), 1);
                    }
                    task.setObstacles(obstacles);
                    System.out.println("Result: " + task.PartII(startPoint, path));
                }
                case 3 -> {

                    Point endpoint = new Point();

                    System.out.print("Ending X: ");
                    endpoint.setX(scan.nextInt());
                    System.out.print("Ending Y: ");
                    endpoint.setY(scan.nextInt());
                    System.out.print("Ending Direction: ");
                    endpoint.setDirection(scan.next());

                    System.out.print("Obstacles : ");
                    int size = scan.nextInt();
                    int obstacleX, obstacleY;
                    HashMap<Point, Integer> obstacles = new HashMap<>();
                    for (int i = 0; i < size; i++) {
                        obstacleX = scan.nextInt();
                        obstacleY = scan.nextInt();
                        obstacles.put(new Point(obstacleX, obstacleY), 1);
                    }
                    task.setObstacles(obstacles);

                    System.out.println("Result: " + task.PartIII(startPoint,endpoint));
                }
                default -> {
                    System.out.println("Thank you for exploring this solution, Good Bye.");
                    return;
                }
            }

        }



    }


}

