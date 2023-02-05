package it.trekkete.amcharts.components.axis;

import it.trekkete.amcharts.Am5Component;

import java.util.UUID;

public abstract class Axis implements Am5Component {

    public enum Direction {
        X,
        Y
    }

    protected UUID id;

    protected String name;
    protected Direction direction;

    public Axis() {
        this.id = UUID.randomUUID();
        this.name = "axis_" + id;
    }

    public String getName() {
        return name;
    }

    public Direction getDirection() {
        return direction;
    }
}
