package ClassiQuarte.BI.Esercizi.GoKart;

public class Pilota extends Thread {
    private Spogliatoio spogliatoio;
    private Pista pista;
    private int numeroGiriDaEffettuare;
    private final int TEMPO_PER_GIRO = 500;

    public Pilota(String name, Spogliatoio spogliatoio, Pista pista, int numeroGiriDaEffettuare) {
        super(name);
        this.spogliatoio = spogliatoio;
        this.pista = pista;
        this.numeroGiriDaEffettuare = numeroGiriDaEffettuare;
    }

    @Override
    public void run() {
        try {
            // 1) Indossare tuta e casco
            spogliatoio.entraSpogliatoio();
            System.out.println(getName() + " entra nello spogliatoio");

            //2) Accedere alla pista
            pista.accediPista();
            System.out.println(getName() + " accede alla pista.");

            // 3) Simulazione giri di pista
            for (int i = 0; i < numeroGiriDaEffettuare; i++) {
                System.out.println(getName() + " effettua il giro numero: " + (i + 1));
                Thread.sleep(TEMPO_PER_GIRO);
            }

            // 4) Liberare la pista
            pista.esciPista();
            System.out.println(getName() + " esce dalla pista.");

            // 5) Tornare allo spogliatoio.
            spogliatoio.esciSpogliatoio();
            System.out.println(getName() + " esce dallo spogliatoio.");

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto");
        }
    }
}
