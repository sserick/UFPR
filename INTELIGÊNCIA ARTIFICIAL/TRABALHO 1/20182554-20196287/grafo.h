#include "resolve.h"

// Estrututa para criar uma matriz que cada casa tem uma cor, se foi explorado e em qual lista está
typedef struct mapaStruct{
	int cor;
	int emNodo;
	int lista;
} mapaStruct;

// Estrutura que tem tudo relacionado ao jogo (linha, coluna, cores e mapa) 
typedef struct jogoStruct{
	int linha, coluna, cores;
	mapaStruct **mapa;
} jogoStruct;

// Estrutura de coordenadas do mapa
typedef struct coordenadas{
	int x, y;
} coordenadas;

// Cria um novo nó e apaga os antigos
void juntaNos(Agraph_t *grafo, Agnode_t *nodoK, Agnode_t *n, Agnode_t *novoNo, int *numNos);

// Cria aresta entre dois nodos de cores diferentes 
void addAresta(Agraph_t *grafo, int lista1, int lista2, int cor1, int cor2);

// Inicia as lista de atributos de cada nodo e anda pelo mapa inteiro separando as cores (floodIt)
void criaGrafo(Agraph_t *grafo, jogoStruct jogo);

