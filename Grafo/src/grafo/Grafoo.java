package Grafo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Clase Nodo que representa un nodo en el grafo.
class Nodo<String> {
    private String valor;               // El valor (o contenido) del nodo.
    private List<Nodo<String>> vecinos; // Lista de nodos vecinos (conectados por aristas).

    public Nodo(String valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
    }

    public String getValor() {
        return valor;
    }

    public List<Nodo<String>> getVecinos() {
        return vecinos;
    }
}

// Clase Grafoo que representa el grafo en sí.
class Grafoo<String> {
    private Map<String, Nodo<String>> nodos; // Un mapeo de valores a nodos.

    public Grafoo() {
        nodos = new HashMap<>();
    }

    // Método para agregar un nodo al grafo.
    public void agregarNodo(String valor) {
        nodos.put(valor, new Nodo<>(valor));
    }

    // Método para agregar una arista entre dos nodos en el grafo.
    public void agregarArista(String valor1, String valor2) {
        Nodo<String> nodo1 = nodos.get(valor1);
        Nodo<String> nodo2 = nodos.get(valor2);
        if (nodo1 != null && nodo2 != null) {
            nodo1.getVecinos().add(nodo2);
            nodo2.getVecinos().add(nodo1);
        }
    }
}
