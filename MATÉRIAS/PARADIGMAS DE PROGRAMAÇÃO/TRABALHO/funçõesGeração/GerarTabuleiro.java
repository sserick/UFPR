package TRABALHO.funçõesGeração;

import TRABALHO.funções.Posição;
import TRABALHO.personagens.*;
import TRABALHO.setores.*;

public class GerarTabuleiro {

    protected Posição posiçãoX;

    // Construtor
    public GerarTabuleiro(Posição posiçãoX) {
        this.posiçãoX = posiçãoX;
    }

    // Getters e Setters
    public Posição getPosiçãoX() {
        return posiçãoX;
    }

    public void setPosiçãoX(Posição posiçãoX) {
        this.posiçãoX = posiçãoX;
    }

    public void gerarTabuleiro(Setor[][] tabuleiro, Jogador[] jogadores) {

        GerarLadosSetor gerarSetores = new GerarLadosSetor();
        GerarPersonagens personagens = new GerarPersonagens();
        GerarPontoChegada posiçãoX = new GerarPontoChegada();

        // Gera as portas e paredes do tabuleiro
        gerarSetores.gerarLados(tabuleiro);

        // Gera a posição do X e marca no setor
        this.posiçãoX = posiçãoX.gerarPosiçãoX(tabuleiro);

        // Gera os jogadores
        personagens.gerarJogadores(jogadores);

        // Gera os inimigos dos setores
        personagens.gerarInimigos(tabuleiro, this.posiçãoX);
    }
}
