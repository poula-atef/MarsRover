package com.example;

public class Node extends Point{
    private Node parent;
    private Point point;

    public Node(Point point){
        super(point.getX(), point.getY(), point.getDirection());
        this.parent = null;
    }

    public Node(Point point,Node parent){
        super(point.getX(), point.getY(), point.getDirection());
        this.parent = parent;
    }

    public Node(int x, int y, String direction, Node parent) {
        super(x, y, direction);
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Point getPoint(){
        if(point == null)
            point = new Point();
        point.setX(this.getX());
        point.setY(this.getY());
        point.setDirection(this.getDirection());
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (this.getX() != point.getX()) return false;
        if (this.getY() != point.getY()) return false;
        return this.getDirection() != null ? this.getDirection().equals(point.getDirection()) : point.getDirection() == null;
    }

    @Override
    public int hashCode() {
        int result = this.getX();
        result = 31 * result + this.getY();
        result = 31 * result + (this.getDirection() != null ? this.getDirection().hashCode() : 0);
        return result;
    }

}
