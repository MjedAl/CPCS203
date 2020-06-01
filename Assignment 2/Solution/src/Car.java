
public class Car {

    private String Brand;
    private int Year;
    private double Rate;
    private boolean Transmission;
    private String Type;
    private boolean Convertible;
    private boolean Taken = false; // i'm gonna use this to know if this car is taken or not

    public Car(String Brand, int Year, double Rate, boolean Transmission, String Type, boolean Convertible) {
        this.Brand = Brand;
        this.Year = Year;
        this.Rate = Rate;
        this.Transmission = Transmission;
        this.Type = Type;
        this.Convertible = Convertible;
    }

    public String PrintDetails() {
        return ("The car Type: " + this.getBrand() + " " + this.getType() + ", Year: " + this.getYear() + ", Transmission: " + (this.isTransmission() ? "Manual" : "Automatic") + (this.isConvertible() ? " and Convertible" : ""));
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }

    public boolean isTransmission() {
        return Transmission;
    }

    public void setTransmission(boolean Transmission) {
        this.Transmission = Transmission;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public void setTaken(boolean Taken) {
        this.Taken = Taken;
    }

    public boolean isTaken() {
        return Taken;
    }
}
