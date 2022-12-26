package SEMANA09.exercicio;

public class ElectronicProduct implements Shop{
    
    // Atributos
    private String productName;
    private String manufacturerName;
    private int weight;
    private int voltage;
    
    // Construtor
    public ElectronicProduct(String productName, String manufacturerName, int weight, int voltage) {
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.weight = weight;
        this.voltage = voltage;
    }

    //Getters
    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public int getWeight() {
        return weight;
    }

    public int getVoltage() {
        return voltage;
    }

    //Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    // Métodos
    public void sell(){
        System.out.println("Vendendo um Produto!");
    }

    public void triggerWarranty(){
        System.out.println("Acionando a garantia do produto!!");
    }

}
