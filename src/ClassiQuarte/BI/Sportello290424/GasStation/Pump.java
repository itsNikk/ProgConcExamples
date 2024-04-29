package ClassiQuarte.BI.Sportello290424.GasStation;

public class Pump {
    private String name;
    private boolean isAvailable;

    public Pump(String name) {
        this.name = name;
        setAvailable(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
