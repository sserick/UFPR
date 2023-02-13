package TRABALHO.personagens;

public class JogadorSuporte extends Jogador {

    // Atributos
    protected int ataque;
    protected int defesa;

    // Construtor
    public JogadorSuporte(int linha, int coluna, boolean estaVivo, int ataque, int defesa) {
        super(linha, coluna, estaVivo);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Getters e Setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque == 1)
            this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa >= 0 && defesa <= 7)
            this.defesa = defesa;
    }

    public void recuperar(char jogada, Personagem jogador) {

        int defesaJogador;

        if (jogador.getClass().getSimpleName() == "JogadorSimples")
            defesaJogador = ((JogadorSimples) jogador).getDefesa();
        else
            defesaJogador = ((JogadorSuporte) jogador).getDefesa();
        defesaJogador = +2;

        if (jogada == 'R' || jogada == 'r') {
            if (defesaJogador > 6)
                defesaJogador = 6;
        } else {
            if (defesaJogador > 7)
                defesaJogador = 7;
        }

        if (jogador.getClass().getSimpleName() == "JogadorSimples")
            ((JogadorSimples) jogador).setDefesa(defesaJogador);
        else
            ((JogadorSuporte) jogador).setDefesa(defesaJogador);
        ;
    }
}
