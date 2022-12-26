#include <iostream>
#include <queue>
#include <string>
#include <limits>
#include "tabuleiro.h"
#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

#define POS(l,c) ((l) * 10 + (c))
#define MAXSTR 512
#define MAXINT 16

struct Move{
    int row, col;
};

struct Goose{
    bool alive;
    Move bestMove[4];
    Move position;
    int value[4];
    int bestValue;
};

int minimax(char *board, int depth, bool isMax, int cont);
char * findBestMoveFox(char *board, char *buf);
char * findBestMoveGoose(char *board, char *buf);
//utility
int howManyGooses(char *board);
int checkFoxSidesFree(char *board);
int utility(char *board, bool isMax);
//utils
int pos_valida(int pos);
int posValida(int l, int c);
int vitoria(char lado, char *tabuleiro);
Move whereIsFox(char *board);
void initGoose(char *board, Goose goose[]);