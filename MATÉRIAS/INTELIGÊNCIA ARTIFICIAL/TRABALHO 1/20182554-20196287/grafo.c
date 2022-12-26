#include "grafo.h"

void juntaNos(Agraph_t *grafo, Agnode_t *nodoK, Agnode_t *n, Agnode_t *novoNo, int *numNos) {
	Agedge_t *aresta;
	
	// Passa todas as arestas do nodo antigo para o novo
    for (aresta = agfstedge(grafo, nodoK); aresta; aresta = agnxtedge(grafo,aresta,nodoK))
		agedge(grafo, novoNo, aresta->node, "",TRUE);
	for (aresta = agfstedge(grafo, n); aresta; aresta = agnxtedge(grafo,aresta,n))
		agedge(grafo, novoNo, aresta->node, "",TRUE);

	aresta = agedge(grafo, novoNo, novoNo, "",FALSE); // Tranforma a aresta em falsa antes de exluir
	agdeledge(grafo, aresta); // Exclui aresta
	agdelnode(grafo, nodoK); // Exclui nodo
	agdelnode(grafo, n);
	(*numNos)--;
}

void addAresta(Agraph_t *grafo, int lista1, int lista2, int cor1, int cor2) {	
	Agnode_t *n, *n2;
	// Aloca as variáveis auxiliares 
    char *lista1Aux = malloc(sizeof(char));
	char *lista2Aux = malloc(sizeof(char));
	char *cor1Aux = malloc(sizeof(char));
	char *cor2Aux = malloc(sizeof(char));
	
    // Passando os valores de int para char 
    sprintf(lista1Aux, "%d", lista1);
	sprintf(lista2Aux, "%d", lista2);
	sprintf(cor1Aux, "%d", cor1);
	sprintf(cor2Aux, "%d", cor2);
	
    // Cria o nodo para a cor e atribui a variavel auxiliar para a cor
    n = agnode(grafo, lista1Aux, TRUE);
	agset(n, "cor", cor1Aux);
	n2 = agnode(grafo, lista2Aux, TRUE);
	agset(n2, "cor", cor2Aux);
	
    // Adiciona uma aresta entre os dois nodos
    agedge(grafo, n, n2, "",TRUE);
}

void criaGrafo(Agraph_t *grafo, jogoStruct jogo) {								
	coordenadas par;
	int i, j, n;
	int lista = 0;
	
    // Cria os atributos para cada nodo 
    agattr(grafo, AGNODE, "cor", "0");
	agattr(grafo, AGNODE, "vertice", "0");
	agattr(grafo, AGNODE, "distancia", "0");

    // Anda por todas as coordenadas do mapa para chamar o floodIt
	for (i = 0; i < jogo.linha; i++) {
		for (j = 0; j < jogo.coluna; j++) {
			if (!jogo.mapa[i][j].emNodo) {
				par.x = i;
				par.y = j;
				n = 0;
				floodIt(jogo, par, jogo.mapa[i][j].cor, &n, lista, grafo);
				lista++;
			}
		}
	}
}