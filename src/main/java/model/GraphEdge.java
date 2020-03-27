package model;

import org.graphstream.graph.implementations.AbstractEdge;
import org.javatuples.Pair;

public class GraphEdge extends AbstractEdge {

    private final Pair<GraphNode, GraphNode> edgeNodes;

    private boolean border;

    public GraphEdge(String id, Pair<GraphNode, GraphNode> edgeNodes, boolean border) {
        super(id, edgeNodes.getValue0(), edgeNodes.getValue1(), false);
        this.edgeNodes = edgeNodes;
        this.border = border;
    }

    public Pair<GraphNode, GraphNode> getEdgeNodes() {
        return edgeNodes;
    }

    public boolean getBorder() {
        return border;
    }

    public double getLength() {
        return Coordinates.distance(edgeNodes.getValue0().getCoordinates(), edgeNodes.getValue1().getCoordinates());
    }

    public static class GraphEdgeBuilder {

        private final Pair<GraphNode, GraphNode> edgeNodes;

        private final String id;

        private boolean border;

        public GraphEdgeBuilder(String id, GraphNode source, GraphNode target, boolean border) {
            this.id = id;
            this.edgeNodes = new Pair<>(source, target);
            this.border = border;
        }

        public GraphEdgeBuilder(String id, GraphNode source, GraphNode target) {
            this.id = id;
            this.edgeNodes = new Pair<>(source, target);
        }

        public GraphEdgeBuilder setBorder(boolean border) {
            this.border = border;
            return this;
        }

        public GraphEdgeBuilder withBorder(boolean border) {
            this.border = border;
            return this;
        }

        public GraphEdge build() {
            return new GraphEdge(id, edgeNodes, border);
        }
    }
}
