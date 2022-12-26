package SEMANA08.exercicio;

public class ImovelNovo extends Imovel{
    
    public ImovelNovo(Endereco endereco, Double preco) {
        this.endereco = endereco;
        this.preco = preco;
    }

    @Override
    public Double calcularValorImove() {
        return this.preco * 365;
    }
    
}
