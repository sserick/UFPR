#include "jogo.h"

jogoStruct leJogo(){
	jogoStruct jogo; 
	int i, j;

	while(!feof(stdin)){
		scanf("%d %d %d",&jogo.linha, &jogo.coluna, &jogo.cores);
		
		jogo.mapa = (mapaStruct**)malloc(jogo.linha * sizeof(mapaStruct*));
		for(i = 0; i < jogo.linha; i++)
			jogo.mapa[i] = (mapaStruct*)malloc(jogo.coluna * sizeof(mapaStruct));

        for(i = 0; i < jogo.linha; i++)
            for(j = 0; j < jogo.coluna; j++){
                scanf("%d ",&jogo.mapa[i][j].cor);
				jogo.mapa[i][j].emNodo = 0;
			}
	}
	return jogo;
}

void imprimeSolucao(char **movimentos, int numMovimentos){

	printf("%d\n", numMovimentos);
  	for(int i = 0; i < numMovimentos; i++)
		printf("%s ", movimentos[i]);
  	printf("\n");
}

void verficaCor (jogoStruct jogo, coordenadas par, coordenadas *aux, Agraph_t *grafo, int cor, int *i, int lista) {

    // Verifica se a cor a esquerda é a mesma 
    if (par.x > 0) { 
        // Se é um nó não explorado e da mesma cor muda de coordenada 
        if (jogo.mapa[par.x - 1][par.y].emNodo == 0) {
            if (jogo.mapa[par.x - 1][par.y].cor == cor) {
                *aux = par;
                aux->x--;
                floodIt(jogo, *aux, cor, i, lista, grafo);
            }
        }else {
            if (jogo.mapa[par.x - 1][par.y].cor != cor) {
                *aux = par;
                aux->x--;
                addAresta(grafo, jogo.mapa[par.x - 1][par.y].lista, lista, jogo.mapa[par.x - 1][par.y].cor, cor);
            }	
        }
    }

    // Verifica se a cor a direita é a mesma
    if (par.x < (jogo.linha - 1)) {
        // Se é um nó não explorado e da mesma cor muda de coordenada
        if (jogo.mapa[par.x + 1][par.y].emNodo == 0) {
            if (jogo.mapa[par.x + 1][par.y].cor == cor) {
                *aux = par;
                aux->x++;
                floodIt(jogo, *aux, cor, i, lista, grafo);
            }
        }else {
            if (jogo.mapa[par.x + 1][par.y].cor != cor) {
                *aux = par;
                aux->x++;
                addAresta(grafo, jogo.mapa[par.x + 1][par.y].lista, lista, jogo.mapa[par.x + 1][par.y].cor, cor);
            }	
        }
    }

    // Verifica se a cor a cima é a mesma
    if (par.y > 0) {
        // Se é um nó não explorado e da mesma cor muda de coordenada 
        if (jogo.mapa[par.x][par.y - 1].emNodo == 0) {
            if (jogo.mapa[par.x][par.y - 1].cor == cor) {
                *aux = par;
                aux->y--;
                floodIt(jogo, *aux, cor, i, lista, grafo);
            }
        }else {
            if (jogo.mapa[par.x][par.y - 1].cor != cor) {
                *aux = par;
                aux->y--;
                addAresta(grafo, jogo.mapa[par.x][par.y - 1].lista, lista, jogo.mapa[par.x][par.y - 1].cor, cor);
            }	
        }
    }

    // Verifica se a cor a baixo é a mesma
    if (par.y < (jogo.coluna - 1)) {
        // Se é um nó não explorado e da mesma cor muda de coordenada
        if (jogo.mapa[par.x][par.y + 1].emNodo == 0) {
            if (jogo.mapa[par.x][par.y + 1].cor == cor) {
                *aux = par;
                aux->y++;
                floodIt(jogo, *aux, cor, i, lista, grafo);
            }
        }else {
            if (jogo.mapa[par.x][par.y + 1].cor != cor) {
                *aux = par;
                aux->y++;
                addAresta(grafo, jogo.mapa[par.x][par.y + 1].lista, lista, jogo.mapa[par.x][par.y + 1].cor, cor);
            }	
        }

    }
}

void floodIt(jogoStruct jogo, coordenadas par, int cor, int *i, int lista, Agraph_t *grafo) {
		coordenadas aux;
        // Marca coordenada atual como explorado
		jogo.mapa[par.x][par.y].emNodo = 1;
		jogo.mapa[par.x][par.y].lista = lista;
		*i++;

        verficaCor (jogo, par, &aux, grafo, cor, i, lista);

	return;
}