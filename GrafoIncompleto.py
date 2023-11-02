import networkx as nx
import matplotlib.pyplot as plt
from termcolor import colored

nodos = int(input(colored("De cuantos nodos quieres tu grafo?: ","yellow")))
G = nx.DiGraph()

for i in range(nodos):
    nombreNodo = input(colored('Dame el nombre del nodo {}: ', 'cyan').format(i+1))
    G.add_node(nombreNodo)

for nodo in G.nodes():
    aristas = int(input(colored("Dime cuantas aristas salen del nodo '{}': ","yellow").format(nodo)))
    for i in range(aristas):
        destino = input(colored("Nodo de destino de la arista '{}': ","cyan").format(i+1))
        G.add_edge(nodo,destino)

nx.draw(G, with_labels=True, node_color='green', font_size=16, node_size=1000)
plt.show()