#include "main.hpp"

int pos_valida(int pos) {
  
  int positions [57] = {0,1,2,3,4,5,6,7,8,9,10,11,12,16,17,18,19,20,21,22,26,27,28,29,30,38,39,40,48,49,50,58,59,60,61,62,66,67,68,69,70,71,72,76,77,78,79,80,81,82,83,84,85,86,87,88,89};

  for (int i = 0; i < 57; i++){
    if (pos == positions[i])
      return 0;
  }
  return 1;
}

int posValida(int l, int c) {
  if(l < 1 || l > 7 || c < 1 || c > 7)
    return 0;
  if((l < 3 || l > 5) && (c < 3 || c > 5))
    return 0;
  return 1;
}

int vitoria(char lado, char *tabuleiro) {
  int l, c, ng;

  if(lado == 'r') {
    ng = 0;
    for(l = 1; l < 8; l++)
      for(c = 1; c < 8; c++)
	if(tabuleiro[POS(l,c)] == 'g')
	  ng++;
    if(ng > 3)
      return 0;
    return 1;
  }
  for(l = 1; l < 8; l++)
    for(c = 1; c < 8; c++)
      if(tabuleiro[POS(l,c)] == 'r') {
	if(posValida(l-1,c) && tabuleiro[POS(l-1,c)] == '-')
	  return 0;
	if(posValida(l+1,c) && tabuleiro[POS(l+1,c)] == '-')
	  return 0;
	if(posValida(l,c-1) && tabuleiro[POS(l,c-1)] == '-')
	  return 0;
	if(posValida(l,c+1) && tabuleiro[POS(l,c+1)] == '-')
	  return 0;
	return 1;
      }
  return 0;
}

Move whereIsFox(char *board){
  Move move;
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 9; j++) {
      if (board[POS(i,j)] == 'r'){
        move.row=i;
        move.col=j;
        return move;
      }
    }
  }
  return move;
}

void initGoose(char *board, Goose goose[]){
  int contG = 0;
  
  for (int i = 0; i < 8; i++){
    for (int j = 0; j < 9; j++){
      if (board[POS(i,j)] == 'g'){
        goose[contG].position.row = i;
        goose[contG].position.col = j;
        goose[contG].alive = true;
        goose[contG].bestValue = INT_MAX;
        contG++;
      }
      if (contG == 12){
        return ;
      }
    }
  }
}