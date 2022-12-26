#include "main.hpp"

int minimax(char *board, int depth, bool isMax, int cont){
  Move fox;
  Goose goose[13]; 
  char lado;
  if (isMax){lado='r';}else{lado='g';}
  int score = vitoria(lado, board); 
  //printf("%d\n",cont);
  if (depth == 3 || score != 0){
    return utility(board, isMax);
  }

  if (isMax){
    int bestValueUp = INT_MIN, bestValueDown = INT_MIN, bestValueRight = INT_MIN, bestValueLeft = INT_MIN;
    fox = whereIsFox(board);
    if(pos_valida(POS(fox.row-1,fox.col))){
      if(board[POS(fox.row-1,fox.col)] == '-'){ //cima
        board[POS(fox.row,fox.col)] = '-';
        board[POS(fox.row-1,fox.col)] = 'r';
        int maximo = minimax(board, depth+1, !isMax, cont++);
        bestValueUp = max(bestValueUp, maximo);
        board[POS(fox.row-1,fox.col)] = '-';
        board[POS(fox.row,fox.col)] = 'r';

      }
    }
    if(pos_valida(POS(fox.row+1,fox.col))){
      if(board[POS(fox.row+1,fox.col)] == '-'){ //baixo
        board[POS(fox.row,fox.col)] = '-';
        board[POS(fox.row+1,fox.col)] = 'r';
        bestValueDown = max(bestValueDown, minimax(board, depth+1, !isMax, cont++));
        board[POS(fox.row+1,fox.col)] = '-';
        board[POS(fox.row,fox.col)] = 'r';
      }
    }
    if(pos_valida(POS(fox.row,fox.col+1))){
      if(board[POS(fox.row,fox.col+1)] == '-'){ //direita
        board[POS(fox.row,fox.col)] = '-';
        board[POS(fox.row,fox.col+1)] = 'r';
        bestValueRight = max(bestValueRight, minimax(board, depth+1, !isMax, cont++));
        board[POS(fox.row,fox.col+1)] = '-';
        board[POS(fox.row,fox.col)] = 'r';
      }
    }
    if(pos_valida(POS(fox.row,fox.col-1))){
      if(board[POS(fox.row,fox.col-1)] == '-'){ //esquerda
        board[POS(fox.row,fox.col)] = '-';
        board[POS(fox.row,fox.col-1)] = 'r';
        bestValueLeft = max(bestValueLeft, minimax(board, depth+1, !isMax, cont++));
        board[POS(fox.row,fox.col-1)] = '-';
        board[POS(fox.row,fox.col)] = 'r';
      }
    }

    int bestValueMove = std::max(max(bestValueRight, bestValueLeft),max(bestValueUp, bestValueDown));

    // inicio lógica pulo
    int bestValueUpJumpAux = INT_MIN, bestValueRightJumpAux = INT_MIN, bestValueLeftJumpAux = INT_MIN, bestValueDownJumpAux = INT_MIN;
    int ValueUpJump = INT_MIN, ValueDownJump = INT_MIN, ValueLeftJump = INT_MIN, ValueRightJump = INT_MIN;
    // cima
    if(pos_valida(POS(fox.row-1,fox.col))){
      if(board[POS(fox.row-1,fox.col)] == 'g'){
        if(pos_valida(POS(fox.row-2,fox.col))){
          if(board[POS(fox.row-2,fox.col)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row-1,fox.col)] = '-';
            board[POS(fox.row-2,fox.col)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                  }
                }
              }
            }
            ValueUpJump = minimax(board, depth+1, !isMax, cont++);
            board[POS(fox.row-1,fox.col)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row-2,fox.col)] = '-';
          }
        }
      }
    }
    int bestValueSecondUp = std::max(max(bestValueUpJumpAux, bestValueLeftJumpAux), bestValueRightJumpAux);

    // baixo
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    if(pos_valida(POS(fox.row+1,fox.col))){
      if(board[POS(fox.row+1,fox.col)] == 'g'){
        if(pos_valida(POS(fox.row+2,fox.col))){
          if(board[POS(fox.row+2,fox.col)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row+1,fox.col)] = '-';
            board[POS(fox.row+2,fox.col)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                  }
                }
              }
            }
            ValueDownJump = minimax(board, depth+1, !isMax, cont++);
            board[POS(fox.row+1,fox.col)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row+2,fox.col)] = '-';
          }
        }
      }
    }
    int bestValueSecondDown = std::max(max(bestValueDownJumpAux, bestValueLeftJumpAux), bestValueRightJumpAux);

    // direita
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    if(pos_valida(POS(fox.row,fox.col+1))){
      if(board[POS(fox.row,fox.col+1)] == 'g'){
        if(pos_valida(POS(fox.row,fox.col+2))){
          if(board[POS(fox.row,fox.col+2)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row,fox.col+1)] = '-';
            board[POS(fox.row,fox.col+2)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                  }
                }
              }
            }
            ValueRightJump = minimax(board, depth+1, !isMax, cont++);
            board[POS(fox.row,fox.col+1)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row,fox.col+2)] = '-';
          }
        }
      }
    }
    int bestValueSecondRight = std::max(max(bestValueDownJumpAux, bestValueUpJumpAux), bestValueRightJumpAux);
    
    // esquerda
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    if(pos_valida(POS(fox.row,fox.col-1))){
      if(board[POS(fox.row,fox.col-1)] == 'g'){
        if(pos_valida(POS(fox.row,fox.col+2))){
          if(board[POS(fox.row,fox.col-2)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row,fox.col-1)] = '-';
            board[POS(fox.row,fox.col-2)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, depth+1, !isMax, cont++);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                  }
                }
              }
            }
            ValueLeftJump = minimax(board, depth+1, !isMax, cont++);
            board[POS(fox.row,fox.col-1)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row,fox.col-2)] = '-';
          }
        }
      }
    }
    int bestValueSecondLeft = std::max(max(bestValueDownJumpAux, bestValueUpJumpAux), bestValueLeftJumpAux);

    int bestValueFirstJump = std::max(max(ValueLeftJump, ValueRightJump), max(ValueUpJump, ValueDownJump));
    int bestValueJump;
    if (bestValueFirstJump == ValueLeftJump){
      if (ValueLeftJump > bestValueSecondLeft){
        bestValueJump = ValueLeftJump;
      }else{
        bestValueJump = bestValueSecondLeft;
      }
    }else if (bestValueFirstJump == ValueRightJump){
      if (ValueRightJump > bestValueSecondRight){
        bestValueJump = ValueRightJump;
      }else{
        bestValueJump = bestValueSecondRight;
      }
    }else if  (bestValueFirstJump == ValueUpJump){
      if (ValueUpJump > bestValueSecondUp){
        bestValueJump = ValueUpJump;
      }else{
        bestValueJump = bestValueSecondUp;
      }
    }else{
      if (ValueDownJump > bestValueSecondDown){
        bestValueJump = ValueDownJump;
      }else{
        bestValueJump = bestValueSecondDown;
      }
    }
    return std::max(bestValueMove, bestValueJump);
  }else{
    int bestValueUp = INT_MAX, bestValueDown = INT_MAX, bestValueRight = INT_MAX, bestValueLeft = INT_MAX;
    initGoose(board, goose);
    for (int i = 0; i < 12; i++){
      if(pos_valida(POS(goose[i].position.row-1, goose[i].position.col))){
        if(board[POS(goose[i].position.row-1, goose[i].position.col)] == '-'){ //cima
          board[POS(goose[i].position.row, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row-1, goose[i].position.col)] = 'g';
          goose[i].value[0] = min(bestValueUp, minimax(board, depth+1, !isMax, cont++));
          board[POS(goose[i].position.row-1, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        }
      }
      if(pos_valida(POS(goose[i].position.row+1, goose[i].position.col))){
        if(board[POS(goose[i].position.row+1, goose[i].position.col)] == '-'){ //baixo
          board[POS(goose[i].position.row, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row+1, goose[i].position.col)] = 'g';
          goose[i].value[1] = min(bestValueDown, minimax(board, depth+1, !isMax, cont++));
          board[POS(goose[i].position.row+1, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        }
      }
      if(pos_valida(POS(goose[i].position.row, goose[i].position.col+1))){
        if(board[POS(goose[i].position.row, goose[i].position.col+1)] == '-'){ //direita
          board[POS(goose[i].position.row, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col+1)] = 'g';
          goose[i].value[2] = min(bestValueRight, minimax(board, depth+1, !isMax, cont++));
          board[POS(goose[i].position.row, goose[i].position.col+1)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        }
      }
      if(pos_valida(POS(goose[i].position.row, goose[i].position.col-1))){
        if(board[POS(goose[i].position.row, goose[i].position.col-1)] == '-'){ //esquerda
          board[POS(goose[i].position.row, goose[i].position.col)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col-1)] = 'g';
          goose[i].value[3] = min(bestValueLeft, minimax(board, depth+1, !isMax, cont++));
          board[POS(goose[i].position.row, goose[i].position.col-1)] = '-';
          board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        }
      }
      goose[i].bestValue = std::min(min(goose[i].value[0], goose[i].value[1]), min(goose[i].value[2], goose[i].value[3]));
    }
    
    return std::min(min(min(min(goose[1].bestValue, goose[2].bestValue),min(goose[3].bestValue, goose[4].bestValue)), goose[0].bestValue),
        min(min(min(goose[5].bestValue, goose[6].bestValue),min(goose[7].bestValue, goose[8].bestValue)),min(min(goose[9].bestValue, goose[10].bestValue),min(goose[11].bestValue, goose[12].bestValue))));
  }
}

char * findBestMoveFox(char *board, char *buf){
    int cont=0;
    int bestValueUp = INT_MIN, bestValueDown = INT_MIN, bestValueRight = INT_MIN, bestValueLeft = INT_MIN;
    Move bestMove,bestMoveUp,bestMoveDown,bestMoveRight,bestMoveLeft, fox;
    char *jumpSequence;

    fox = whereIsFox(board);
    if(pos_valida(POS(fox.row-1, fox.col))){
      if(board[POS(fox.row-1, fox.col)] == '-'){ //cima
        board[POS(fox.row, fox.col)] = '-';
        board[POS(fox.row-1, fox.col)] = 'r';
        int valueUp = minimax(board, 0, false,cont);
        board[POS(fox.row-1, fox.col)] = '-';
        board[POS(fox.row, fox.col)] = 'r';
        if (valueUp > bestValueUp){
          bestMoveUp.row = fox.row-1;
          bestMoveUp.col = fox.col;
          bestValueUp = valueUp;
        }
      }
    }
    if(pos_valida(POS(fox.row+1, fox.col))){
      if(board[POS(fox.row+1, fox.col)] == '-'){ //baixo
        board[POS(fox.row, fox.col)] = '-';
        board[POS(fox.row+1, fox.col)] = 'r';
        int valueDown = minimax(board, 0, false,cont);
        board[POS(fox.row+1, fox.col)] = '-';
        board[POS(fox.row, fox.col)] = 'r';
        if (valueDown > bestValueDown){
          bestMoveDown.row = fox.row+1;
          bestMoveDown.col = fox.col;
          bestValueDown = valueDown;
        }
      }
    }
    if(pos_valida(POS(fox.row, fox.col+1))){
      if(board[POS(fox.row, fox.col+1)] == '-'){ //direita
        board[POS(fox.row, fox.col)] = '-';
        board[POS(fox.row, fox.col+1)] = 'r';
        int valueRight = minimax(board, 0, false,cont);
        board[POS(fox.row, fox.col+1)] = '-';
        board[POS(fox.row, fox.col)] = 'r';
        if (valueRight > bestValueRight){
          bestMoveRight.row = fox.row;
          bestMoveRight.col = fox.col+1;
          bestValueRight = valueRight;
        }
      }
    }
    if(pos_valida(POS(fox.row, fox.col-1))){
      if(board[POS(fox.row, fox.col-1)] == '-'){ //esquerda
        board[POS(fox.row, fox.col)] = '-';
        board[POS(fox.row, fox.col-1)] = 'r';
        int valueLeft = minimax(board, 0, false, cont);
        board[POS(fox.row, fox.col-1)] = '-';
        board[POS(fox.row, fox.col)] = 'r';
        if (valueLeft > bestValueLeft){
          bestMoveLeft.row = fox.row;
          bestMoveLeft.col = fox.col-1;
          bestValueLeft = valueLeft;
        }
      }
    }

    int bestValueMove = std::max(max(bestValueRight, bestValueLeft),max(bestValueUp, bestValueDown));
    if (bestValueMove == bestValueUp){
      bestMove = bestMoveUp;
    }else if (bestValueMove == bestValueDown){
      bestMove = bestMoveDown;
    }else if (bestValueMove == bestValueRight){
      bestMove = bestMoveRight;
    }else{
      bestMove = bestMoveLeft;
    }
    // inicio lógica pulo
    int bestValueUpJumpAux = INT_MIN, bestValueRightJumpAux = INT_MIN, bestValueLeftJumpAux = INT_MIN, bestValueDownJumpAux = INT_MIN;
    int ValueUpJump = INT_MIN, ValueDownJump = INT_MIN, ValueLeftJump = INT_MIN, ValueRightJump = INT_MIN;
    Move secondJumpUp, secondJumpUpUp, secondJumpUpRight, secondJumpUpLeft, secondJumpDown, secondJumpDownDown, secondJumpDownRight, secondJumpDownLeft, secondJumpRight, secondJumpRightRight, secondJumpRightUp, secondJumpRightDown, secondJumpLeft, secondJumpLeftLeft, secondJumpLeftUp, secondJumpLeftDown;
    Move firstJumpUp,firstJumpDown,firstJumpRight,firstJumpLeft;
    // cima
    if(pos_valida(POS(fox.row-1,fox.col))){
      if(board[POS(fox.row-1,fox.col)] == 'g'){
        if(pos_valida(POS(fox.row-2,fox.col))){
          if(board[POS(fox.row-2,fox.col)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row-1,fox.col)] = '-';
            board[POS(fox.row-2,fox.col)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                    if (valueUpJumpAux > bestValueUpJumpAux){
                      secondJumpUpUp.row = foxAux.row-2;
                      secondJumpUpUp.col = foxAux.col;
                      bestValueUpJumpAux = valueUpJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                    if (valueRightJumpAux > bestValueRightJumpAux){
                      secondJumpUpRight.row = foxAux.row;
                      secondJumpUpRight.col = foxAux.col+2;
                      bestValueRightJumpAux = valueRightJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                    if (valueLeftJumpAux > bestValueLeftJumpAux){
                      secondJumpUpLeft.row = foxAux.row;
                      secondJumpUpLeft.col = foxAux.col-2;
                      bestValueLeftJumpAux = valueLeftJumpAux;
                    }
                  }
                }
              }
            }
            ValueUpJump = minimax(board, 0, false, cont);
            board[POS(fox.row-1,fox.col)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row-2,fox.col)] = '-';
            firstJumpUp.row = fox.row-2;
            firstJumpUp.col = fox.col;
          }
        }
      }
    }
    int bestValueSecondUp = std::max(max(bestValueUpJumpAux, bestValueLeftJumpAux), bestValueRightJumpAux);
    if (bestValueSecondUp == bestValueUpJumpAux){
      secondJumpUp = secondJumpUpUp;
    }else if (bestValueSecondUp == bestValueLeftJumpAux){
      secondJumpUp = secondJumpUpLeft;
    }else{
      secondJumpUp = secondJumpUpRight;
    }
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    // baixo
    if(pos_valida(POS(fox.row+1,fox.col))){
      if(board[POS(fox.row+1,fox.col)] == 'g'){
        if(pos_valida(POS(fox.row+2,fox.col))){
          if(board[POS(fox.row+2,fox.col)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row+1,fox.col)] = '-';
            board[POS(fox.row+2,fox.col)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                    if (valueRightJumpAux > bestValueRightJumpAux){
                      secondJumpDownRight.row = foxAux.row;
                      secondJumpDownRight.col = foxAux.col+2;
                      bestValueRightJumpAux = valueRightJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                    if (valueLeftJumpAux > bestValueLeftJumpAux){
                      secondJumpDownLeft.row = foxAux.row;
                      secondJumpDownLeft.col = foxAux.col-2;
                      bestValueLeftJumpAux = valueLeftJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                    if (valueDownJumpAux > bestValueDownJumpAux){
                      secondJumpDownDown.row = foxAux.row+2;
                      secondJumpDownDown.col = foxAux.col;
                      bestValueDownJumpAux = valueDownJumpAux;
                    }
                  }
                }
              }
            }
            ValueDownJump = minimax(board, 0, false, cont);
            board[POS(fox.row+1,fox.col)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row+2,fox.col)] = '-';
            firstJumpDown.row = fox.row+2;
            firstJumpDown.col = fox.col;
          }
        }
      }
    }
    int bestValueSecondDown = std::max(max(bestValueDownJumpAux, bestValueLeftJumpAux), bestValueRightJumpAux);
    if (bestValueSecondDown == bestValueDownJumpAux){
      secondJumpDown = secondJumpDownDown;
    }else if (bestValueSecondDown == bestValueLeftJumpAux){
      secondJumpDown = secondJumpDownLeft;
    }else{
      secondJumpDown = secondJumpDownRight;
    }
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    // direita
    if(pos_valida(POS(fox.row,fox.col+1))){
      if(board[POS(fox.row,fox.col+1)] == 'g'){
        if(pos_valida(POS(fox.row,fox.col+2))){
          if(board[POS(fox.row,fox.col+2)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row,fox.col+1)] = '-';
            board[POS(fox.row,fox.col+2)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                    if (valueUpJumpAux > bestValueUpJumpAux){
                      secondJumpRightUp.row = foxAux.row-2;
                      secondJumpRightUp.col = foxAux.col;
                      bestValueUpJumpAux = valueUpJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col+1))){// direita
              if(board[POS(foxAux.row,foxAux.col+1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col+2))){
                  if(board[POS(foxAux.row,foxAux.col+2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col+1)] = '-';
                    board[POS(foxAux.row,foxAux.col+2)] = 'r';
                    int valueRightJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col+1)] = 'g';
                    board[POS(foxAux.row,foxAux.col+2)] = '-';
                    if (valueRightJumpAux > bestValueRightJumpAux){
                      secondJumpRightRight.row = foxAux.row;
                      secondJumpRightRight.col = foxAux.col+2;
                      bestValueRightJumpAux = valueRightJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                    if (valueDownJumpAux > bestValueDownJumpAux){
                      secondJumpRightDown.row = foxAux.row+2;
                      secondJumpRightDown.col = foxAux.col;
                      bestValueDownJumpAux = valueDownJumpAux;
                    }
                  }
                }
              }
            }
            ValueRightJump = minimax(board, 0, false, cont);
            board[POS(fox.row,fox.col+1)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row,fox.col+2)] = '-';
            firstJumpRight.row = fox.row+2;
            firstJumpRight.col = fox.col;
          }
        }
      }
    }
    int bestValueSecondRight = std::max(max(bestValueDownJumpAux, bestValueUpJumpAux), bestValueRightJumpAux);
    if (bestValueSecondRight == bestValueDownJumpAux){
      secondJumpRight = secondJumpRightDown;
    }else if (bestValueSecondRight == bestValueUpJumpAux){
      secondJumpRight = secondJumpRightUp;
    }else{
      secondJumpRight = secondJumpRightRight;
    }
    bestValueUpJumpAux = bestValueRightJumpAux = bestValueLeftJumpAux = bestValueDownJumpAux = INT_MIN;
    // esquerda
    if(pos_valida(POS(fox.row,fox.col-1))){
      if(board[POS(fox.row,fox.col-1)] == 'g'){
        if(pos_valida(POS(fox.row,fox.col+2))){
          if(board[POS(fox.row,fox.col-2)] == '-'){
            board[POS(fox.row,fox.col)] = '-';
            board[POS(fox.row,fox.col-1)] = '-';
            board[POS(fox.row,fox.col-2)] = 'r';

            Move foxAux = whereIsFox(board);
            if(pos_valida(POS(foxAux.row-1,foxAux.col))){// cima
              if(board[POS(foxAux.row-1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row-2,foxAux.col))){
                  if(board[POS(foxAux.row-2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row-1,foxAux.col)] = '-';
                    board[POS(foxAux.row-2,foxAux.col)] = 'r';
                    int valueUpJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row-1,foxAux.col)] = 'g';
                    board[POS(foxAux.row-2,foxAux.col)] = '-';
                    if (valueUpJumpAux > bestValueUpJumpAux){
                      secondJumpLeftUp.row = foxAux.row-2;
                      secondJumpLeftUp.col = foxAux.col;
                      bestValueUpJumpAux = valueUpJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row+1,foxAux.col))){// baixo
              if(board[POS(foxAux.row+1,foxAux.col)] == 'g'){
                if(pos_valida(POS(foxAux.row+2,foxAux.col))){
                  if(board[POS(foxAux.row+2,foxAux.col)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row+1,foxAux.col)] = '-';
                    board[POS(foxAux.row+2,foxAux.col)] = 'r';
                    int valueDownJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row+1,foxAux.col)] = 'g';
                    board[POS(foxAux.row+2,foxAux.col)] = '-';
                    if (valueDownJumpAux > bestValueDownJumpAux){
                      secondJumpLeftDown.row = foxAux.row+2;
                      secondJumpLeftDown.col = foxAux.col;
                      bestValueDownJumpAux = valueDownJumpAux;
                    }
                  }
                }
              }
            }
            if(pos_valida(POS(foxAux.row,foxAux.col-1))){// esquerda
              if(board[POS(foxAux.row,foxAux.col-1)] == 'g'){
                if(pos_valida(POS(foxAux.row,foxAux.col-2))){
                  if(board[POS(foxAux.row,foxAux.col-2)] == '-'){
                    board[POS(foxAux.row,foxAux.col)] = '-';
                    board[POS(foxAux.row,foxAux.col-1)] = '-';
                    board[POS(foxAux.row,foxAux.col-2)] = 'r';
                    int valueLeftJumpAux = minimax(board, 0, false, cont);
                    board[POS(foxAux.row,foxAux.col)] = 'r';
                    board[POS(foxAux.row,foxAux.col-1)] = 'g';
                    board[POS(foxAux.row,foxAux.col-2)] = '-';
                    if (valueLeftJumpAux > bestValueLeftJumpAux){
                      secondJumpLeftLeft.row = foxAux.row;
                      secondJumpLeftLeft.col = foxAux.col-2;
                      bestValueLeftJumpAux = valueLeftJumpAux;
                    }
                  }
                }
              }
            }
            ValueLeftJump = minimax(board, 0, false, cont);
            board[POS(fox.row,fox.col-1)] = 'g';
            board[POS(fox.row,fox.col)] = 'r';
            board[POS(fox.row,fox.col-2)] = '-';
            firstJumpLeft.row = fox.row-2;
            firstJumpLeft.col = fox.col;
          }
        }
      }
    }
    int bestValueSecondLeft = std::max(max(bestValueDownJumpAux, bestValueUpJumpAux), bestValueLeftJumpAux);
    if (bestValueSecondLeft == bestValueDownJumpAux){
      secondJumpLeft = secondJumpLeftDown;
    }else if (bestValueSecondLeft == bestValueUpJumpAux){
      secondJumpLeft = secondJumpLeftUp;
    }else{
      secondJumpLeft = secondJumpLeftLeft;
    }
    
    int bestValueJump = std::max(max(ValueUpJump, ValueRightJump), max(ValueDownJump, ValueLeftJump));
    
    if (bestValueMove > bestValueJump){
      sprintf(buf, "r m %d %d %d %d", fox.row, fox.col, bestMove.row, bestMove.col);
    }else{
      if (ValueUpJump == bestValueJump){
        if (bestValueSecondUp >= ValueUpJump){
          sprintf(buf, "r s 3 %d %d %d %d %d %d", fox.row, fox.col, firstJumpUp.row, firstJumpUp.col, secondJumpUp.row, secondJumpUp.col);
        }else{
          sprintf(buf, "r s 2 %d %d %d %d", fox.row, fox.col, firstJumpUp.row, firstJumpUp.col);
        }
      }else if (ValueRightJump == bestValueJump){
        if (bestValueSecondRight >= ValueRightJump){
          sprintf(buf, "r s 3 %d %d %d %d %d %d", fox.row, fox.col, firstJumpRight.row, firstJumpRight.col, secondJumpRight.row, secondJumpRight.col);
        }else{
          sprintf(buf, "r s 2 %d %d %d %d", fox.row, fox.col, firstJumpRight.row, firstJumpRight.col);
        }
      }else if (ValueDownJump == bestValueJump){
        if (bestValueSecondDown >= ValueDownJump){
          sprintf(buf, "r s 3 %d %d %d %d %d %d", fox.row, fox.col, firstJumpDown.row, firstJumpDown.col, secondJumpDown.row, secondJumpDown.col);
        }else{
          sprintf(buf, "r s 2 %d %d %d %d", fox.row, fox.col, firstJumpDown.row, firstJumpDown.col);
        }
      }else{
        if (bestValueSecondLeft >= ValueLeftJump){
          sprintf(buf, "r s 3 %d %d %d %d %d %d", fox.row, fox.col, firstJumpLeft.row, firstJumpLeft.col, secondJumpLeft.row, secondJumpLeft.col);
        }else{
          sprintf(buf, "r s 2 %d %d %d %d", fox.row, fox.col, firstJumpLeft.row, firstJumpLeft.col);
        }
      }
    }

    return buf;
}

char * findBestMoveGoose(char *board, char *buf){
  int cont=0;
  int bestValueUp = INT_MAX, bestValueDown = INT_MAX, bestValueRight = INT_MAX, bestValueLeft = INT_MAX;
  Goose goose[13];

  initGoose(board, goose);
  
  for (int i = 0; i < 12; i++){
    if(pos_valida(POS(goose[i].position.row-1, goose[i].position.col))){
      if(board[POS(goose[i].position.row-1, goose[i].position.col)] == '-'){ //cima
        board[POS(goose[i].position.row, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row-1, goose[i].position.col)] = 'g';
        goose[i].value[0] = min(bestValueUp, minimax(board, 0, true, cont));
        board[POS(goose[i].position.row-1, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        goose[i].bestMove[0].row = goose[i].position.row-1;
        goose[i].bestMove[0].col = goose[i].position.col;
      }
    }
    if(pos_valida(POS(goose[i].position.row+1, goose[i].position.col))){
      if(board[POS(goose[i].position.row+1, goose[i].position.col)] == '-'){ //baixo
        board[POS(goose[i].position.row, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row+1, goose[i].position.col)] = 'g';
        goose[i].value[1] = min(bestValueDown, minimax(board, 0, true, cont));
        board[POS(goose[i].position.row+1, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        goose[i].bestMove[1].row = goose[i].position.row+1;
        goose[i].bestMove[1].col = goose[i].position.col;
      }
    }
    if(pos_valida(POS(goose[i].position.row, goose[i].position.col+1))){
      if(board[POS(goose[i].position.row, goose[i].position.col+1)] == '-'){ //direita
        board[POS(goose[i].position.row, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col+1)] = 'g';
        goose[i].value[2] = min(bestValueRight, minimax(board, 0, true, cont));
        board[POS(goose[i].position.row, goose[i].position.col+1)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        goose[i].bestMove[2].row = goose[i].position.row;
        goose[i].bestMove[2].col = goose[i].position.col+1;
      }
    }
    if(pos_valida(POS(goose[i].position.row, goose[i].position.col-1))){
      if(board[POS(goose[i].position.row, goose[i].position.col-1)] == '-'){ //esquerda
        board[POS(goose[i].position.row, goose[i].position.col)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col-1)] = 'g';
        goose[i].value[3] = min(bestValueLeft, minimax(board, 0, true, cont));
        board[POS(goose[i].position.row, goose[i].position.col-1)] = '-';
        board[POS(goose[i].position.row, goose[i].position.col)] = 'g';
        goose[i].bestMove[3].row = goose[i].position.row;
        goose[i].bestMove[3].col = goose[i].position.col-1;
      }
    }
    goose[i].bestValue = std::min(min(goose[i].value[0], goose[i].value[1]), min(goose[i].value[2], goose[i].value[3]));
  }
  
  int smallestValue = 0, posGoose = 0;
  for (int i = 0; i < 13; i++){
    if (goose[i].bestValue < smallestValue){
      smallestValue = goose[i].bestValue;
      posGoose = i;
    }
  }
printf("%d\n",posGoose);
  if (goose[posGoose].bestValue == goose[posGoose].value[0]){
    //printf("0i:%d j: %d\n",goose[posGoose].bestMove[0].row, goose[posGoose].bestMove[0].col);
    sprintf(buf, "g m %d %d %d %d", goose[posGoose].position.row, goose[posGoose].position.col, goose[posGoose].bestMove[0].row, goose[posGoose].bestMove[0].col);
  }else if (goose[posGoose].bestValue == goose[posGoose].value[1]){
  //  printf("1i:%d j: %d\n",goose[posGoose].bestMove[1].row, goose[posGoose].bestMove[1].col);
    sprintf(buf, "g m %d %d %d %d", goose[posGoose].position.row, goose[posGoose].position.col, goose[posGoose].bestMove[1].row, goose[posGoose].bestMove[1].col);
  }else if (goose[posGoose].bestValue == goose[posGoose].value[2]){
//    printf("2i:%d j: %d\n",goose[posGoose].bestMove[2].row, goose[posGoose].bestMove[2].col);
    sprintf(buf, "g m %d %d %d %d", goose[posGoose].position.row, goose[posGoose].position.col, goose[posGoose].bestMove[2].row, goose[posGoose].bestMove[2].col);
  }else{
  //  printf("3i:%d j: %d\n",goose[posGoose].bestMove[3].row, goose[posGoose].bestMove[3].col);
    sprintf(buf, "g m %d %d %d %d", goose[posGoose].position.row, goose[posGoose].position.col, goose[posGoose].bestMove[3].row, goose[posGoose].bestMove[3].col);
  }

  return buf;
}