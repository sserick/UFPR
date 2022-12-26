package SEMANA09.exercicio;

public class Service implements Shop{

    //Atributos
    private String format;
    private int duration;
    private String providerName;
    
    // Construtor
    public Service(String format, int duration, String providerName) {
        this.format = format;
        this.duration = duration;
        this.providerName = providerName;
    }

    // Getters
    public String getFormat() {
        return format;
    }

    public int getDuration() {
        return duration;
    }

    public String getProviderName() {
        return providerName;
    }

    // Setters
    public void setFormat(String format) {
        this.format = format;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    // Métodos
    public void sell(){
        System.out.println("Vendendo um serviço!");
    }

    public void triggerWarranty(){
        System.out.println("Acionando a garantia do serviço!!");
    }
}
