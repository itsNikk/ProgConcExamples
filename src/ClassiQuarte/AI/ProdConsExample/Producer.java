package ClassiQuarte.AI.ProdConsExample;

public class Producer extends Thread {

    private CellaCondivisa cella;

    public Producer(String name, CellaCondivisa cella) {
        super(name);
        this.cella = cella;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                cella.setValore(i);
                //System.out.print(" P:" + valore);
            } catch (InterruptedException c) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
