#include "struct.hpp"
#include "main.hpp"

int howManyGooses(char *board){
  int contG=0;
  for (int i = 1; i < 8; i++){
    for (int j = 1; j < 8; j++){
      if (board[POS(i,j)] == 'g'){
        contG++;
      }
    }
  }
  return contG;
}
int checkFoxSidesFree(char *board){
  Move fox=whereIsFox(board);
  int contF=0;

  if(pos_valida(POS(fox.row-1,fox.col))){
    if(board[POS(fox.row-1,fox.col)] == 'g'){
      if(pos_valida(POS(fox.row-2,fox.col))){
        if(board[POS(fox.row-2,fox.col)] != '-'){
          contF++;
        }
      }else{
        contF++; 
      }
    }
  }else{
    contF++;
  }
  if(pos_valida(POS(fox.row+1,fox.col))){
    if(board[POS(fox.row+1,fox.col)] == 'g'){
      if(pos_valida(POS(fox.row+2,fox.col))){
        if(board[POS(fox.row+2,fox.col)] != '-'){
          contF++;
        }
      }else{
        contF++;
      }
    }
  }else{
    contF++;
  }
  if(pos_valida(POS(fox.row,fox.col+1))){
    if(board[POS(fox.row,fox.col+1)] == 'g'){
      if(pos_valida(POS(fox.row,fox.col+2))){
        if(board[POS(fox.row,fox.col+2)] != '-'){
          contF++;
        }
      }else{
        contF++;
      }
    }
  }else{
    contF++;
  }
  if(pos_valida(POS(fox.row,fox.col-1))){
    if(board[POS(fox.row,fox.col-1)] == 'g'){
      if(pos_valida(POS(fox.row,fox.col-2))){
        if(board[POS(fox.row,fox.col-2)] != '-'){
          contF++;
        }
      }else{
        contF++;
      }
    }
  }else{
    contF++;
  }
  return contF;
}

int utility(char *board, bool isMax) {
  int contG=0,contF=0;
  char player;
  lastScore.fox = 0; lastScore.goose = 0;
  if (isMax){ player='g';} else{ player='r';}// jogador anterior é o inverso do isMax pq chama no proximo

  if (player=='r'){
    contG = howManyGooses(board);
    if ((13-contG) > lastScore.fox){
      lastScore.fox = 13 - contG;
      return lastScore.fox;
    }else{
      contF= checkFoxSidesFree(board);
      if (-contF == lastScore.goose){
        return 0;
      }else{
        lastScore.goose = -contF;
        return lastScore.goose;
      }
    }
  }else{
    contF= checkFoxSidesFree(board);
    if(-contF < lastScore.goose){
      lastScore.goose = -contF;
      return lastScore.goose;
    }else if(-contF == lastScore.goose){
      contG = howManyGooses(board);
      if ((13-contG) == lastScore.fox){
        return 0;
      }else{
        lastScore.fox = 13 - contG;
        return lastScore.fox;
      }
    }
  }
  return 0;
}