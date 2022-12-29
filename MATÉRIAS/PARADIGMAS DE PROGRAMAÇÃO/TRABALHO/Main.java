package TRABALHO;

import java.util.Scanner;

import TRABALHO.personages.Personage;
import TRABALHO.personages.SinglePlayer;
import TRABALHO.personages.SupportPlayer;
import TRABALHO.sectors.Sector;

public class Main {
    
    public static void main(String[] args) {
        
        // Inicializando Funções usadas 
        GenerateBoard generateBoard = new GenerateBoard();
        ShowInfo showBoard = new ShowInfo();
        Scanner input;

        // Atributos
        char choice;
        int cycles = 0;
        Sector board[][] = new Sector[5][5];
        Personage player1 = new SinglePlayer(2, 2, 2, 6, true);
        Personage player2 = new SupportPlayer(2, 2, 1, 7, true);
        
        // Iniciando o Tabuleiro
        generateBoard.generate(board);
        board[2][2].setHasSinglePlayer(true);
        board[2][2].setHasSupportPlayer(true);

        while (cycles < 26){

            choice = showBoard.showMenu(cycles);
            
            if (cycles == 0){
                

            } else {

            }

            cycles++;
        }
        
        showBoard.show(board);

    }
}
