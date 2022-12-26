#include "resolve.h"

void buscaLargura(Agraph_t *grafo, int *distMaior, Agnode_t **filaNos, int *i, int *tamFilaNos, char **caminho) {
	int distancia;
	int j = 1;
	Agnode_t *vertice, *vertice2;
	Agedge_t *aresta;

	// Verifica todos os nodos da fronteira 
    while (*i < *tamFilaNos) {
		vertice = filaNos[*i]; 
			for (aresta = agfstedge(grafo, vertice); aresta; aresta = agnxtedge(grafo,aresta,vertice)) {
				vertice2 = aresta->node;
				
                // Verifica se o nodo não é explorado
                if (*(agget(vertice2, "vertice")) == '0') {
					filaNos[*tamFilaNos] = vertice2;
					(*tamFilaNos)++;
					distancia = *(agget(vertice, "distancia"));
					
                    // Procura a distância maior
                    if (distancia > *distMaior) {
						caminho[j] = (agnameof(vertice2));
						j++;
						*distMaior = distancia;
					}
					char *distChar = malloc(sizeof(char));
					sprintf(distChar, "%d", distancia);
					agset(vertice2, "vertice", "1"); // Marca vertice como explorado
					agset(vertice2, "distancia", distChar); // Marca a distância do nodo
				}
			}
		*i++;
	}
}

void resolveJogo(Agraph_t *grafo, Agnode_t *nodoK, char **movimentos, int *numMovimentos) { 
	Agnode_t **filaNos, *n, *novoNo;
	int i, distMaior, tamFilaNos, aux = -1, flag = 0, numNos = agnnodes(grafo);
	char *corAux, **caminho;

    // Anda enquanto tiver mais que 1 nodo no grafo
	while (numNos > 1) {
		filaNos = malloc(sizeof(Agnode_t*) * numNos);
		agset(nodoK, "vertice", "1");
		filaNos[0] = nodoK;
		distMaior = i = 0;
		tamFilaNos = 1;
		caminho = malloc(sizeof(char*) * numNos);
		caminho[0] = (agnameof(nodoK));
		buscaLargura(grafo, &distMaior, filaNos, &i, &tamFilaNos, caminho);

        // Marca o nodo como não explorado 
	  	for (n=agfstnode(grafo); n; n=agnxtnode(grafo,n)) {
			agset(n, "vertice", "0");
	  	} 

        // No raiz recebe nova cor
	  	char *auxChar = malloc(sizeof(char));
		sprintf(auxChar, "%d", aux);
		n = agnode(grafo, caminho[1], FALSE);
		novoNo = agnode(grafo, auxChar, TRUE);
		aux--;
		corAux = agget(n, "cor");
		agset(novoNo, "cor", corAux);
		movimentos[*numMovimentos] = corAux;
		(*numMovimentos)++;

		free(auxChar);
		free(filaNos);
		free(caminho);

        // Enquanto tem nodo vizinho da mesma cor ele junta os nodos
		while (1) {
			for (Agedge_t *aresta = agfstedge(grafo, nodoK); aresta; aresta = agnxtedge(grafo,aresta,nodoK)) {
				if (strcmp(corAux, (agget(aresta->node, "cor"))) == 0) {
					auxChar = malloc(sizeof(char));
					sprintf(auxChar, "%d", aux);
					novoNo = agnode(grafo, auxChar, TRUE);
					aux--;
					agset(novoNo, "cor", (agget(aresta->node, "cor")));
					juntaNos(grafo, nodoK, aresta->node, novoNo, &numNos);
					free(auxChar);
					nodoK = novoNo;
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				break;
			}
			flag = 0;
		} 
	}
}