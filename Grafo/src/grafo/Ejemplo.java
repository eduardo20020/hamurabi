import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VisualizacionGrafo extends JFrame {

    public VisualizacionGrafo() {
        super("Visualización de Grafo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un nuevo grafo JGraphX
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Definir un diseño para los nodos
        mxIGraphLayout layout = new mxCircleLayout(graph);
        layout.execute(parent);

        // Obtener el modelo del grafo
        Map<String, Object> vertexMap = new HashMap<>();
        graph.getModel().beginUpdate();

        try {
            // Agregar nodos y guardar sus referencias
            Grafo<String> grafo = new Grafo<>();
            grafo.agregarNodo("brandon");
            grafo.agregarNodo("delia");
            grafo.agregarNodo("adri");
            grafo.agregarNodo("michi");

            vertexMap.put("brandon", graph.insertVertex(parent, null, "brandon", 20, 20, 80, 30));
            vertexMap.put("delia", graph.insertVertex(parent, null, "delia", 120, 20, 80, 30));
            vertexMap.put("adri", graph.insertVertex(parent, null, "adri", 20, 120, 80, 30));
            vertexMap.put("michi", graph.insertVertex(parent, null, "michi", 120, 120, 80, 30));

            // Agregar aristas
            grafo.agregarArista("brandon", "delia");
            grafo.agregarArista("brandon", "michi");
            grafo.agregarArista("brandon", "adri");
            grafo.agregarArista("adri", "michi");

            graph.insertEdge(parent, null, "", vertexMap.get("brandon"), vertexMap.get("delia"));
            graph.insertEdge(parent, null, "", vertexMap.get("brandon"), vertexMap.get("michi"));
            graph.insertEdge(parent, null, "", vertexMap.get("brandon"), vertexMap.get("adri"));
            graph.insertEdge(parent, null, "", vertexMap.get("adri"), vertexMap.get("michi"));
        } finally {
            graph.getModel().endUpdate();
        }

        // Crear un componente de visualización de grafo
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VisualizacionGrafo frame = new VisualizacionGrafo();
            frame.setVisible(true);
        });
    }
}
