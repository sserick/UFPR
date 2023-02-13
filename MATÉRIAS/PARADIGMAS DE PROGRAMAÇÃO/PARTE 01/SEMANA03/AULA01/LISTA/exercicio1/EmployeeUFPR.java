package SEMANA03.AULA01.LISTA.exercicio1;

public class EmployeeUFPR {
    
    // Atributos
    private String name;
    private String registration;
    private Date birthDate;
    private String office;
    
    // Construtor
    public EmployeeUFPR(String name, String registration, Date birthDate, String office) {
        this.name = name;
        this.registration = registration;
        this.birthDate = birthDate;
        this.office = office;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getOffice() {
        return office;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    
}
