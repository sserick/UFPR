#include <stdio.h>
#include <stdlib.h>
#include <graphviz/cgraph.h>

// Faz uma busca em largura para achar o nodo mais distante para trazer ele mais perto da raiz 
void buscaLargura(Agraph_t *grafo, int *distMaior, Agnode_t **filaNos, int *i, int *tamFilaNos, char **caminho);

// Anda por todos os nodos do grafo procurando a próxima cor
void resolveJogo(Agraph_t *grafo, Agnode_t *nodoK, char **movimentos, int *numMovimentos);

