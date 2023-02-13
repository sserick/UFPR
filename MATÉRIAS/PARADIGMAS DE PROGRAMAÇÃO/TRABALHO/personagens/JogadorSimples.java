package TRABALHO.personagens;

public class JogadorSimples extends Jogador {

    // Atributos
    protected int ataque;
    protected int defesa;

    public JogadorSimples(int linha, int coluna, boolean estaVivo, int ataque, int defesa) {
        super(linha, coluna, estaVivo);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Getters e Setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque == 2)
            this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa >= 0 && defesa <= 6)
            this.defesa = defesa;
    }
}
