package TRABALHO.funções;

public class Posição {
    // Atributos
    int linha;
    int coluna;

    // Construtor
    public Posição(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    // Getters e Setters
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        if (linha >= 0 && linha <= 4) {
            this.linha = linha;
        }
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        if (coluna >= 0 && coluna <= 4) {
            this.coluna = coluna;
        }
    }
}
