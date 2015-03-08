package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class Node {

    protected Vector vec;
    protected Node parent;
    protected double f, g, h;

    protected Node(Vector vec, Node parent, double g, double h) {

        this.vec = vec;
        this.parent = parent;
        this.g = g;
        this.h = h;
        f = g + h;

    }

    public Coordinates getLoc() {

        return new Coordinates(vec.x * Pathfinding.scale, vec.y * Pathfinding.scale);

    }

}
