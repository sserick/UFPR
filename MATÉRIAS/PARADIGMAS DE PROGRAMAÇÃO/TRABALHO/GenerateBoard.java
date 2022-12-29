package TRABALHO;

import java.util.Random;
import TRABALHO.sectors.Sector;
import TRABALHO.sectors.NormalSector;
import TRABALHO.sectors.HiddenSector;
import TRABALHO.sectors.PrivateSector;

public class GenerateBoard {

    // Gera um random para a posição do X
    private Position generatePositionX(Sector[][] board){
        Random random;
        int posLin, posCol;
        Position posX = new Position(0, 0);
        random = new Random();

        posLin = random.nextInt(4);
        posCol = random.nextInt(4);

        while (posLin == 2 && posCol == 2) {
            posLin = random.nextInt(4);
            posCol = random.nextInt(4);
        }

        posX.setLin(posLin);
        posX.setCol(posCol);

        board[posLin][posCol].setHasX(true);

        return posX;
    }

    // Gera um random para ver se será lado ou porta
    private char randomDoorWall(String type){
        Random random;
        int wallsOrDoor;
        random = new Random();

        wallsOrDoor = random.nextInt(1);

        if ((wallsOrDoor == 0) && (type == "left" || type == "right")){
            return '|';
        } else if ((wallsOrDoor == 0) && (type == "top" || type == "bottom")){
            return '-';
        } else {
            return '*';
        } 
    }

    // Gera um random para o tipo de setor
    private Sector typeSector(int lin, int col) {
        Random random;
        int typeSector;
        Sector temp;

        random = new Random();
        typeSector = random.nextInt(2);

        if (typeSector == 0){
            temp = new NormalSector(lin, col, null, false, 0, false, false, false, false);
        } else if (typeSector == 1) {
            temp = new HiddenSector(lin, col, null, false, 0, false, false, false, false);
        } else {
            temp = new PrivateSector(lin, col, null, false, 0, false, false, false, false);
        }

        return temp;
    }


    private char[] generateSides(char top, char left, char bottom, char right){
        char sides[] = new char[4];
        
        sides[0] = top;
        sides[1] = left;
        sides[2] = bottom;
        sides[3] = right;

        return sides;
    }
    
    // Gera os lados e a porta
    private void generateWallsDoors(Sector[][] board){
        int lin, col;
        char right, bottom;
        char[] temp;

        for (lin = 0; lin < 5; lin++){
            for (col = 0; col < 5; col++){

                board[lin][col] = typeSector(lin, col);

                if (lin == 0 && col == 0){
                    board[lin][col].setSides(generateSides('-', '|', randomDoorWall("bottom"), randomDoorWall("right")));
                } else if (lin == 0 && col != 0 && col != 4){
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides('-', right, randomDoorWall("bottom"), randomDoorWall("right")));
                } else if (lin == 0 && col == 4){
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides('-', right, randomDoorWall("bottom"), '|'));
                } else if (lin > 0 && col == 0 && lin != 4){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    board[lin][col].setSides(generateSides(bottom, '|', randomDoorWall("bottom"), randomDoorWall("right")));
                } else if ((lin > 0 && lin < 4) && (col > 0 && col < 4)){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides(bottom, right, randomDoorWall("bottom"), randomDoorWall("right")));
                } else if ((lin > 0 && lin < 4) && (col == 4)){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides(bottom, right, randomDoorWall("bottom"), '|'));
                } else if (lin == 4 && col == 0){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    board[lin][col].setSides(generateSides(bottom, '|', '-', randomDoorWall("right")));
                } else if (lin == 4 && col == 4){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides(bottom, right, '-', '|'));
                } else if (lin == 4 && col != 0 && col != 4){
                    temp = board[lin-1][col].getSides();
                    bottom = temp[2];
                    temp = board[lin][col-1].getSides();
                    right = temp[3];
                    board[lin][col].setSides(generateSides(bottom, right, '-', randomDoorWall("right")));
                } else {
                    System.out.println("Erro!!");
                }

                // Centro
                if (lin == 2 && col == 2){
                    board[lin][col].setSides(generateSides('*', '*', '*', '*'));
                    board[lin][col].setShowSector(true);
                    board[lin][col].setCenter(true);
                }
            }
        }
    }

    public void generate(Sector[][] board){

        // Gera as portas e paredes do tabuleiro
        generateWallsDoors(board);

        // Gera a posição do X e marca no setor
        generatePositionX(board);
    }
    
}
