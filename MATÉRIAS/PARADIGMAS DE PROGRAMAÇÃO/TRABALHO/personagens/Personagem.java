package TRABALHO.personagens;

import TRABALHO.funções.Posição;

public abstract class Personagem extends Posição {

    protected boolean estaVivo;

    // Construtor
    public Personagem(int linha, int coluna, boolean estaVivo) {
        super(linha, coluna);
        this.estaVivo = estaVivo;
    }

    // Getters e Setters
    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
}
