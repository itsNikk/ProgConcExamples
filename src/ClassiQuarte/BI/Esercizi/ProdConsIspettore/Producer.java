package ClassiQuarte.BI.Esercizi.ProdConsIspettore;

public class Producer extends Thread {
    private Magazzino magazzino;

    public Producer(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        // non termina mai
        while (true) {
            try {
                sleep(500);
                magazzino.AddMerce((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                System.out.println(getName() + "OOPS");
            }
        }
    }
}
