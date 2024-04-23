package ClassiQuarte.AI.Esercizi.TheBouncer;

public class Utente extends Thread {

    private int eta;
    private Bouncer bouncer;

    public Utente(String name, int eta, Bouncer bouncer) {
        // super(name) = setName(name)
        super(name);
        this.eta = eta;
        this.bouncer = bouncer;
    }


    @Override
    public void run() {
        try {
            bouncer.enterUser(eta);
            sleep((int) (Math.random() * 5000) + 2000);
            bouncer.exitUser();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto perchè minorenne");
        }
    }
}
