package ClassiQuarte.AI.Esercizi.Benzinaio;

public class Veicolo extends Thread {

    private PompaBenzina pompaAssegnata;
    private StazioneBenzina stazioneBenzina;

    public Veicolo(String name, StazioneBenzina stazioneBenzina) {
        setName(name);
        this.stazioneBenzina = stazioneBenzina;
    }

    @Override
    public void run() {
        try {
            //1) Guido per uin po'
            sleep((int) (Math.random() * 5000));
            //2) accedo alla stazione
            stazioneBenzina.getPump(this);
            //3) faccio rifornimento
            sleep((int) (Math.random() * 2000));
            //4) Esco
            stazioneBenzina.releasePump(this);
        } catch (InterruptedException interruptedException) {
            System.out.println("ooops");
        }
    }

    public PompaBenzina getPompaAssegnata() {
        return pompaAssegnata;
    }

    public void setPompaAssegnata(PompaBenzina pompaAssegnata) {
        this.pompaAssegnata = pompaAssegnata;
    }
}
