package SEMANA04.exercicio;

public class HourlyEmployee extends Employee {
    // Atributos
    private Double timeValue;
    private int numberOfHoursWorked;
    
    // Construtor
    public HourlyEmployee(String name, String registration, boolean ehForeigner, Double timeValue,
            int numberOfHoursWorked) {
        super(name, registration, ehForeigner);
        this.timeValue = timeValue;
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    // Getters
    public Double getTimeValue() {
        return timeValue;
    }

    public int getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    // Setters
    public void setTimeValue(Double timeValue) {
        this.timeValue = timeValue;
    }
    
    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    // Métodos
    public void printHourlyEmployee(){
        super.printEmployee();
        System.out.println("Valor da Hora: " + getTimeValue());
        System.out.println("Número de horas trabalhadas: " + getNumberOfHoursWorked());
    }

    public Double calculateFinalSalary(){
        return timeValue * numberOfHoursWorked;
    }
}
