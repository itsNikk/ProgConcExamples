package ClassiQuarte.BI.Esercizi.ParcheggioOnDemand;

public class Slot {
    private int numeroSlot;
    private boolean isAvailable;

    public Slot(int numeroSlot) {
        this.numeroSlot = numeroSlot;
        this.isAvailable = true; //true = libero
    }

    public int getNumeroSlot() {
        return numeroSlot;
    }

    public void setNumeroSlot(int numeroSlot) {
        this.numeroSlot = numeroSlot;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
