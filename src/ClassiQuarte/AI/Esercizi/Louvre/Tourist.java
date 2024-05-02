package ClassiQuarte.AI.Esercizi.Louvre;

public class Tourist extends Thread {
    private Museum museum;

    public Tourist(String name, Museum museum) {
        super(name); //  super(name) = setName(name)
        this.museum = museum;
    }

    @Override
    public void run() {
        try {
            //1) Attesa random...
            int lucchiniTime = (int) (Math.random() * (5000 - 1000)) + 1000; // waitTime
            int oneBallTime = (int) (Math.random() * (1000 - 200)) + 200; // waitTime
            //System.out.println(getName() + " passeggia per la città");
            sleep(lucchiniTime);
            // 2) Entra nel museo, se può
            museum.enterMuseum(this);
            //3) guardo il quadro
            System.out.println(getName() + " guarda il quadro...");
            sleep(oneBallTime);
            //4) esco dal museo
            museum.exitMuseum(this);

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto");
        }
    }
}
