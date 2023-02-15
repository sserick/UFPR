package TRABALHO.funcaoGeracao;

import TRABALHO.funcoes.Posicao;
import TRABALHO.personagens.*;
import TRABALHO.setores.*;

public class GerarTabuleiro {

    protected Posicao posiçãoX;

    // Construtor
    public GerarTabuleiro(Posicao posiçãoX) {
        this.posiçãoX = posiçãoX;
    }

    // Getters e Setters
    public Posicao getPosiçãoX() {
        return posiçãoX;
    }

    public void setPosiçãoX(Posicao posiçãoX) {
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
