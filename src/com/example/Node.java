package com.example;

public class Node{
    private Node parent;
    private Point point;

    private String nodeDirection;
    public Node(){
        this.parent = null;
    }

    public Node(Node node){
        this.point = new Point(node.getPoint());
        this.parent = null;
    }



    public String getNodeDirection() {
        return nodeDirection;
    }

    public void setNodeDirection(String nodeDirection) {
        this.nodeDirection = nodeDirection;
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
        point.setX(point.getX());
        point.setY(point.getY());
        point.setDirection(point.getDirection());
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void goFront(Point point) {
        this.point.setX(this.point.getX() + point.getX());
        this.point.setY(this.point.getY() + point.getY());
    }

    public String getPointDirection(){
        return this.point.getDirection();
    }

    public void setPointDirection(String direction){
        this.point.setDirection(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (parent != null ? !parent.equals(node.parent) : node.parent != null) return false;
        if (point != null ? !point.equals(node.point) : node.point != null) return false;
        return nodeDirection != null ? nodeDirection.equals(node.nodeDirection) : node.nodeDirection == null;
    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (nodeDirection != null ? nodeDirection.hashCode() : 0);
        return result;
    }
}
