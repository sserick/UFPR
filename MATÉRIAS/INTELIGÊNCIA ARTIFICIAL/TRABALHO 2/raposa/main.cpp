#include "main.hpp"

int main(int argc, char **argv){
  char buf[MAXSTR];
  char tabuleiro[MAXSTR]; 
  char lado_meu;
  char lado_adv;
  char tipo_mov_adv;
  int num_mov_adv;
  int mov_adv_l[MAXINT];
  int mov_adv_c[MAXINT];
  int i;
  
  tabuleiro_conecta(argc, argv);

  while (1){
    tabuleiro_recebe(buf);

    sscanf(strtok(buf, " \n"), "%c", &lado_meu);
    sscanf(strtok(NULL, " \n"), "%c", &lado_adv);
    sscanf(strtok(NULL, " \n"), "%c", &tipo_mov_adv);
    if(tipo_mov_adv == 'm') {
      num_mov_adv = 2;
      for(i = 0; i < num_mov_adv; i++) {
        sscanf(strtok(NULL, " \n"), "%d", &(mov_adv_l[i]));
        sscanf(strtok(NULL, " \n"), "%d", &(mov_adv_c[i]));
      }
    }
    else if(tipo_mov_adv == 's') {
      sscanf(strtok(NULL, " \n"), "%d", &num_mov_adv);
      for(i = 0; i < num_mov_adv; i++) {
        sscanf(strtok(NULL, " \n"), "%d", &(mov_adv_l[i]));
        sscanf(strtok(NULL, " \n"), "%d", &(mov_adv_c[i]));
      }
    }
    strncpy(tabuleiro, strtok(NULL, "."), MAXSTR);

    printf("%c\n", lado_meu);
    printf("%c %c", lado_adv, tipo_mov_adv);
    if(tipo_mov_adv != 'n') {
      if(tipo_mov_adv == 's') 
        printf(" %d", num_mov_adv);
      for(i = 0; i < num_mov_adv; i++) {
        printf(" %d", mov_adv_l[i]);
        printf(" %d", mov_adv_c[i]);
      }
    }
    printf("\n");
    printf("%s", tabuleiro);
    
    if(lado_meu == 'r')
      findBestMoveFox(tabuleiro, buf);
    else
      findBestMoveGoose(tabuleiro, buf);

    tabuleiro_envia(buf);
  }
}
