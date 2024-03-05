package ClassiQuinte.BookedParkingLot;

public class Automobilista extends Thread {

    private final Parcheggio p;
    private final int slot;

    private static int index;

    public Automobilista(Parcheggio p, int slot) {
        setName("Automobilista" + ++index);
        this.p = p;
        this.slot = slot;
    }

    @Override
    public void run() {
        p.prenotaPosto(slot);
        try {
            sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        p.liberaPosto(slot);
    }
}
