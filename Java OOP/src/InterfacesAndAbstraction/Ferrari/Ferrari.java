package InterfacesAndAbstraction.Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    public String getModel() {
        return model;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }
    @Override
    public String toString(){
        return String.format("%s/%s/%s/%s", this.getModel(), this.brakes(), this.gas(), this.getDriverName());
    }
}
