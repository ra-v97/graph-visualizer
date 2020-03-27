package model;

import common.ElementAttributes;
import org.graphstream.graph.implementations.AbstractGraph;
import org.graphstream.graph.implementations.SingleNode;

public abstract class GraphNode extends SingleNode {

    private final String symbol;

    private Coordinates coordinates;

    protected GraphNode(AbstractGraph graph, String id, String symbol, double xCoordinate, double yCoordinate, double zCoordinate) {
        this(graph, id, symbol, new Coordinates(xCoordinate, yCoordinate, zCoordinate));
    }

    protected GraphNode(AbstractGraph graph, String id, String symbol, Coordinates coordinates) {
        super(graph, id);
        super.setAttribute(ElementAttributes.FROZEN_LAYOUT);
        this.symbol = symbol;
        this.coordinates = coordinates;
    }

    public void rotate() {
        coordinates = coordinates.getRotation();
    }

    public void rotate(Double pitch, Double yaw, Double roll) {
        coordinates = coordinates.rotate(pitch, yaw, roll);
    }

    public double getXCoordinate() {
        return coordinates.getX();
    }

    public double getYCoordinate() {
        return coordinates.getY();
    }

    public double getZCoordinate() {
        return coordinates.getZ();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
