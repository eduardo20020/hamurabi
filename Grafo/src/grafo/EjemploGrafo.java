package grafo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EjemploGrafo {

            static class Nodo<T> {
                   private T valor;               // El valor (o contenido) del nodo.
                   private List<Nodo<T>> vecinos; // Lista de nodos vecinos (conectados por aristas).

                   public Nodo(T valor) {
                       this.valor = valor;
                       this.vecinos = new ArrayList<>();
                   }

                   public T getValor() {
                       return valor;
                   }

                   public List<Nodo<T>> getVecinos() {
                       return vecinos;
                   }
           }

           static class Grafo<T> {
                  private Map<T, Nodo<T>> nodos; // Un mapeo de valores a nodos.

                  public Grafo() {
                      nodos = new HashMap<>();
                  }

                  // Método para agregar un nodo al grafo.
                  public void agregarNodo(T valor) {
                      nodos.put(valor, new Nodo<>(valor));
                  }

                  // Método para agregar una arista entre dos nodos en el grafo.
                  public void agregarArista(T valor1, T valor2) {
                      Nodo<T> nodo1 = nodos.get(valor1);
                      Nodo<T> nodo2 = nodos.get(valor2);
                      if (nodo1 != null && nodo2 != null) {
                          nodo1.getVecinos().add(nodo2);
                          nodo2.getVecinos().add(nodo1);
                      }
                  }
           }




           public static void main(String[] args) {
               // Crear un nuevo grafo
               Grafo<String> grafo = new Grafo<>();

               // Agregar nodos al grafo
               grafo.agregarNodo("brandon");
               grafo.agregarNodo("delia");
               grafo.agregarNodo("adri");
               grafo.agregarNodo("michi");

               // Agregar aristas
               grafo.agregarArista("brandon", "delia");
               grafo.agregarArista("brandon", "michi");
               grafo.agregarArista("brandon", "adri");
               grafo.agregarArista("adri", "michi");

               // Recorrer y mostrar los nodos y sus vecinos
               for (String nodo : grafo.nodos.keySet()) {
                   Nodo<String> nodoActual = grafo.nodos.get(nodo);
                   System.out.print("Nodo " + nodoActual.getValor() + " esta conectado con: ");
                   for (Nodo<String> vecino : nodoActual.getVecinos()) {
                       System.out.print(vecino.getValor() + " ");
                   }
                   System.out.println();
               }
    }
}
