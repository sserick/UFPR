package TRABALHO.setores;

import TRABALHO.personagens.Inimigo;

public class SetorPrivado extends Setor {

    public SetorPrivado(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, Inimigo[] inimigos,
            boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, quantidadeInimigos, inimigos, mostrarSetor);
    }
}
