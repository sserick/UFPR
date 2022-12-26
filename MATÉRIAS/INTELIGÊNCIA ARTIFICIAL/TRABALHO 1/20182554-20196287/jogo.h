#include "grafo.h"

// Lê o arquivo de entrada, aloca uma matriz com as dimensões da entrada e lê os valores da matriz do arquivo
jogoStruct leJogo();

// Impreme a quantidade de movimentos e os movimentos feitos
void imprimeSolucao(char **movimentos, int numMovimentos);

// Pega a coordenada e verifica se a cor é igual (nas 4 direções) se for igual vai para a próxima coordenada se não cria nodos no grafos e liga eles com uma arestra
void verficaCor (jogoStruct jogo, coordenadas par, coordenadas *aux, Agraph_t *grafo, int cor, int *i, int lista);

// Começa no canto superior esquerdo e vai verificando cada coordenada e chamando a função verificaCor
void floodIt(jogoStruct jogo, coordenadas par, int cor, int *i, int lista, Agraph_t *grafo);
