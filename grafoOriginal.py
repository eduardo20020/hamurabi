import networkx as nx
import matplotlib.pyplot as plt
from termcolor import colored
import os
os.system('pip install networkx matplotlib termcolor')
os.system('cls')

def crear_grafo():
    G = nx.DiGraph()
    num_nodos = int(input(colored("\tDe cuantos nodos quieres tu grafo?: ","yellow")))
    print()

    for i in range(num_nodos):
        nodo = input(colored('Dame el nombre del nodo: ', 'red'))
        G.add_node(nodo)
        num_aristas = int(input(colored("Dime cuantas aristas salen del nodo : ","blue")))
        for j in range(num_aristas):
            arista = input(colored("Nodo de destino de la arista '{}': ","cyan").format(j+1))
            G.add_edge(nodo, arista)
        print()
    return G

def dibujar_grafo(G):
    nx.draw(G, with_labels=True, node_color='green', font_size=16, node_size=700)
    plt.show()

G = crear_grafo()
dibujar_grafo(G)
