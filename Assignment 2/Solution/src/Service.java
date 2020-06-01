

public class Service {

    private String ServiceType;
    private double ServiceRate;

    public Service(String ServiceType, double ServiceRate) {
        this.ServiceType = ServiceType;
        this.ServiceRate = ServiceRate;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public double getServiceRate() {
        return ServiceRate;
    }

    public void setServiceRate(double ServiceRate) {
        this.ServiceRate = ServiceRate;
    }

}
