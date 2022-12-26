package SEMANA04.exercicio;

public class MonthlyEmployeeFreela extends MonthlyEmployee {
    // Atributos
    private int workedDays;

    // Construtor
    public MonthlyEmployeeFreela(String name, String registration, boolean ehForeigner, Double monthlySalary,
            int workedDays) {
        super(name, registration, ehForeigner, monthlySalary);
        this.workedDays = workedDays;
    }

    // Getter
    public int getWorkedDays() {
        return workedDays;
    }

    // Setter
    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }
}
