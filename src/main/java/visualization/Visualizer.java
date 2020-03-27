package visualization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.GraphNode;
import model.ModelGraph;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Visualizer {
    private ModelGraph graph;

    public Visualizer(ModelGraph graph) {
        this.graph = graph;
    }

    public void visualize() {
        graph.display();
        ModelGraph clone = new ModelGraph(graph);
        clone.rotate();
        clone.display();
    }

}
