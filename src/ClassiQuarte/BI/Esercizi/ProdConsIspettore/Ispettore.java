package ClassiQuarte.BI.Esercizi.ProdConsIspettore;

public class Ispettore extends Thread {
    private Magazzino magazzino;

    public Ispettore(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(3000);
                magazzino.enterIspettore();
            }
        } catch (InterruptedException e) {
            System.out.println("Ispettore ooops");
        }

    }
}
