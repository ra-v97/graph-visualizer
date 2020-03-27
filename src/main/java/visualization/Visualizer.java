package visualization;

import model.ModelGraph;
import org.graphstream.ui.view.Viewer;

public class Visualizer {
    private ModelGraph graph;

    public Visualizer(ModelGraph graph) {
        this.graph = graph;
    }

    public void visualize() {
        graph.display();
        ModelGraph clone = new ModelGraph(graph);
        for (double i = 0; i < 3d; i += 0.005d) {
            clone.rotate(i, 0d, 0.01d);
            ModelGraph clone2 = new ModelGraph(clone); // Need to insert them once again
            Viewer view = clone2.display();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
