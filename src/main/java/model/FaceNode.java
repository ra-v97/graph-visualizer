package model;

import org.graphstream.graph.implementations.AbstractGraph;
import org.javatuples.Triplet;

public class FaceNode extends GraphNode {

    private static final String FACE_SYMBOL = "F";

    private  Triplet<Vertex, Vertex, Vertex> triangle;

    private boolean R;

    public FaceNode(AbstractGraph graph, String id, Coordinates coordinates) {
        super(graph, id, FACE_SYMBOL, coordinates);
    }

    public FaceNode(AbstractGraph graph, String id, Vertex v1, Vertex v2, Vertex v3) {
        super(graph, id, FACE_SYMBOL, getFacePosition(v1, v2, v3));
        triangle = new Triplet<>(v1, v2, v3);
        R = false;
    }


    public Triplet<Vertex, Vertex, Vertex> getTriangle(){
        return triangle;
    }

    public void setR(boolean R) {
        this.R = R;
    }

    public boolean isR() {
        return R;
    }

    public Triplet<Vertex, Vertex, Vertex> getTriangleVertices() {
        return triangle;
    }

    private static Coordinates getFacePosition(Vertex v1, Vertex v2, Vertex v3) {
        return new Coordinates(getFaceXCoordinate(v1, v2, v3), getFaceYCoordinate(v1, v2, v3), getFaceZCoordinate(v1, v2, v3));
    }

    private static double getFaceXCoordinate(Vertex v1, Vertex v2, Vertex v3) {
        return (v1.getXCoordinate() + v2.getXCoordinate() + v3.getXCoordinate()) / 3d;
    }

    private static double getFaceYCoordinate(Vertex v1, Vertex v2, Vertex v3) {
        return (v1.getYCoordinate() + v2.getYCoordinate() + v3.getYCoordinate()) / 3d;
    }

    private static double getFaceZCoordinate(Vertex v1, Vertex v2, Vertex v3) {
        return (v1.getZCoordinate() + v2.getZCoordinate() + v3.getZCoordinate()) / 3d;
    }
}
