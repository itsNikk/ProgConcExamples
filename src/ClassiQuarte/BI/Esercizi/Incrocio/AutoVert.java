package ClassiQuarte.BI.Esercizi.Incrocio;

public class AutoVert extends Thread {

    private Incrocio incrocio;

    public AutoVert(Incrocio incrocio) {
        this.incrocio = incrocio;
    }

    @Override
    public void run() {
        try {

            incrocio.attraversaVerticale();
            System.out.println(getName() + " sta attraversando in verticale");
            sleep(2000);
            System.out.println(getName() + " libera verticale");
            incrocio.liberaVerticale();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto");
        }
    }
}
