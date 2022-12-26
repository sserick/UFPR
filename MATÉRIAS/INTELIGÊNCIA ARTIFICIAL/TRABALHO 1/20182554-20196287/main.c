#include "jogo.h"

int main(){
	jogoStruct jogo;
	char *movimentos[30000];
	int numMovimentos = 0;
	Agraph_t *grafo;

	jogo = leJogo();
	grafo = agopen("grafo", Agundirected, NULL);
	
	criaGrafo(grafo, jogo);
	resolveJogo(grafo, agfstnode(grafo), movimentos, &numMovimentos);
	imprimeSolucao(movimentos, numMovimentos);

	free(jogo.mapa);
	agclose(grafo);
	
	return 0;
}