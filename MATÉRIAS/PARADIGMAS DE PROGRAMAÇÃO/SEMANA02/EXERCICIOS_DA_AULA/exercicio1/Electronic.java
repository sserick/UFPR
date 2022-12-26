package SEMANA02.EXERCICIOS_DA_AULA.exercicio1;

public class Electronic {

    private String name;
    private String color;
    private int voltage;
    private double price;

    public Electronic(String name) {
        this.name = name;
    }

    public Electronic(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Electronic(String name, String color, int voltage) {
        this.name = name;
        this.color = color;
        this.voltage = voltage;
    }

    public Electronic(String color, int voltage) {
        this.color = color;
        this.voltage = voltage;
    }
    
    public Electronic(String name, String color, int voltage, double price) {
        this.name = name;
        this.color = color;
        this.voltage = voltage;
        this.price = price;
    }

    public void imprimir(){
        System.out.println("Tipo: " + name);
        System.out.println("Cor: " + color);
        System.out.println("Voltagem: " + voltage);
        System.out.println("Preço: " + price);
        System.out.println("------------------------");
    }
    
}
