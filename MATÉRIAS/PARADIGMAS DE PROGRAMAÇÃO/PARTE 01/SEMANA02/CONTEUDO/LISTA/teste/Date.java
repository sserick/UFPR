package SEMANA02.CONTEUDO.LISTA.teste;

public class Date {
    
    int dia, mes, ano;

    public void armazenar(int dia, int mes, int ano) {
            
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void imprimir() {

        System.out.printf("%d/%d/%d\n", this.dia, this.mes, this.ano);
    }
}
