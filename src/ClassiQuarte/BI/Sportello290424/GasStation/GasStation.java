package ClassiQuarte.BI.Sportello290424.GasStation;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    private final int numPumps;
    private final List<Pump> availablePumps;

    public GasStation(int numPumps) {
        this.numPumps = numPumps;
        availablePumps = new ArrayList<>();
        for (int i = 1; i <= numPumps; i++) availablePumps.add(new Pump("Pump#" + (i + 1)));
    }

    public synchronized Pump startRefuel(Vehicle vehicle) throws InterruptedException {
        while (AreAllPumpsBusy()) {
            System.out.println(vehicle.getName() + " aspetta una pompa libera");
            wait();
        }

        Pump assignedPump = FindFirstFreePump();
        assignedPump.setAvailable(false);
        System.out.println(vehicle.getName() + " riceve la pompa " + assignedPump.getName());
        return assignedPump;
    }

    public synchronized void endRefuel(Vehicle vehicle) {
        System.out.println(vehicle.getName() + " libera la pompa " + vehicle.getAssignedPump().getName());
        vehicle.getAssignedPump().setAvailable(true);
        notifyAll();
    }

    private boolean AreAllPumpsBusy() {
        for (int i = 0; i < availablePumps.size(); i++) {
            if (availablePumps.get(i).isAvailable()) return false;
        }
        return true;
    }

    private Pump FindFirstFreePump() {
        for (int i = 0; i < availablePumps.size(); i++) {
            if (availablePumps.get(i).isAvailable()) return availablePumps.get(i);
        }
        //ATTENZIONE: rischioso ma necessario...
        return null;
    }
}
