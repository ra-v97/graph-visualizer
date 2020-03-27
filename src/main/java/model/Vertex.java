package model;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AbstractGraph;
import org.graphstream.graph.implementations.AbstractNode;

import java.util.Objects;

public class Vertex extends GraphNode {

    private static final String VERTEX_SYMBOL = "V";

    public Vertex(AbstractGraph graph, String id, Coordinates coordinates) {
        super(graph, id, VERTEX_SYMBOL, coordinates);
    }

    public static class VertexBuilder {

        private final AbstractGraph graph;

        private final String id;

        private double xCoordinate;

        private double yCoordinate;

        private double zCoordinate;

        public VertexBuilder(AbstractGraph graph, String id) {
            this.graph = graph;
            this.id = id;
        }

        public VertexBuilder setCoordinates(Coordinates coordinates){
            this.xCoordinate = coordinates.getX();
            this.yCoordinate = coordinates.getY();
            this.zCoordinate = coordinates.getZ();
            return this;
        }

        public VertexBuilder setXCoordinate(double xCoordinate) {
            this.xCoordinate = xCoordinate;
            return this;
        }

        public VertexBuilder setYCoordinate(double yCoordinate) {
            this.yCoordinate = yCoordinate;
            return this;
        }

        public VertexBuilder setZCoordinate(double zCoordinate) {
            this.zCoordinate = zCoordinate;
            return this;
        }

        public Vertex build() {
            return new Vertex(graph, id, new Coordinates(xCoordinate, yCoordinate, zCoordinate));
        }
    }

    /*
    I am kind of sorry for this but THE MIGHTY api that library exposes
    doesn't allow to override a default java hashcode method used to identify
    objects in neighborMap. So firstly we need to find and retrieve object
    with given properties and then run this function again with 'correct' reference.
     */
    @Override
    public <T extends Edge> T getEdgeBetween(Node node) {
        for(AbstractNode e : this.neighborMap.keySet()){
            if(Objects.equals(e.getId(), node.getId())){
                return super.getEdgeBetween(e);
            }
        }
        return null;
    }
}
