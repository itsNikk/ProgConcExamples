package ClassiQuarte.BI.Esercizi.GoKart;

public class Main {


    public static void main(String[] args) {
        final int POSTI_SPOGLIATOIO = 2;
        final int NUM_PILOTI = 8;
        final int NUM_KART = 4;
        final int NUM_GIRI = 15;

        Spogliatoio spogliatoio = new Spogliatoio(POSTI_SPOGLIATOIO);
        Pista pista = new Pista(NUM_KART);

        for (int i = 0; i < NUM_PILOTI; i++) {
            new Pilota("Pilota(" + (i + 1) + ")", spogliatoio, pista, NUM_GIRI).start();
        }

    }
}
