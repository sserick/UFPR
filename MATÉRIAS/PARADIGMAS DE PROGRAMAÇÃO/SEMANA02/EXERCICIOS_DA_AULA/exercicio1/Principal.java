package SEMANA02.EXERCICIOS_DA_AULA.exercicio1;

public class Principal {
    
    public static void main(String[] args) {
        
        Electronic microondas = new Electronic("Microondas", "Branco", 110, 1500.00);
        Electronic televisao = new Electronic("Televisão", "Preta");
        Electronic liquidificador = new Electronic("Liquidificador", "Vermelho", 220);
        Electronic ventilador = new Electronic("Ventilador");
        Electronic monitor = new Electronic("Preto", 110);

        microondas.imprimir();
        televisao.imprimir();
        liquidificador.imprimir();
        ventilador.imprimir();
        monitor.imprimir();
    }
}
