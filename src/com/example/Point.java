package com.example;

class Point{
    private int x;
    private int y;

    private String direction;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
        this.direction = point.getDirection();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction.toUpperCase();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void replacePoint(Point newPoint){
        this.x = newPoint.x;
        this.y = newPoint.y;
    }

    public void goFront(Point point) {
        this.x += point.getX();
        this.y += point.getY();
    }

    public void goBack(Point point) {
        this.x -= point.getX();
        this.y -= point.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
