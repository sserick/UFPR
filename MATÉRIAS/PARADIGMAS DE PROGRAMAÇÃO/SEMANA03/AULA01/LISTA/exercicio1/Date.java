package SEMANA03.AULA01.LISTA.exercicio1;

public class Date {
    
    // Atributos
    private int day;
    private int month;
    private int year;

    // Construtores
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Métodos
    public void printDate(){
        System.out.printf("%d/%d/%d\n", this.day, this.month, this.year);
    }
}
