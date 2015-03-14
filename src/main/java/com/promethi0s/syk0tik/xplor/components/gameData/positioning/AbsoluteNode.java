package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class AbsoluteNode extends Node {

    private Coordinates loc;

    protected AbsoluteNode(Coordinates loc, Vector vec, Node parent, double g, double h) {

        super(vec, parent, g, h);
        this.loc = loc;

    }

    @Override
    public Coordinates getLoc() {

        return loc;

    }

}
