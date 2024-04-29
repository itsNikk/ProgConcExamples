package ClassiQuarte.BI.Sportello290424.GasStation;

public class Vehicle extends Thread {

    private GasStation gasStation;
    private Pump assignedPump;

    public Vehicle(String name, GasStation gasStation) {
        super(name);
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        try {
            //1) Guida
            int driveTime = (int) (Math.random() * (3000 - 1000)) + 1000;
            int refuelTime = (int) (Math.random() * (2000 - 500)) + 500;
            sleep(driveTime);
            setAssignedPump(gasStation.startRefuel(this));
            sleep(refuelTime);
            gasStation.endRefuel(this);

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }

    public Pump getAssignedPump() {
        return assignedPump;
    }

    public void setAssignedPump(Pump assignedPump) {
        this.assignedPump = assignedPump;
    }
}
