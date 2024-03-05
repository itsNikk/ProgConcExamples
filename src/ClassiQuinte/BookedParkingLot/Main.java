package ClassiQuinte.BookedParkingLot;

public class Main {

    private static final int NUMERO_POSTI = 8;
    private static int NUM_AUTOMOBILISTI = 20;

    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio(NUMERO_POSTI);


        for (int i = 0; i < NUM_AUTOMOBILISTI; i++) {
            int postoDaPrenotare = i % NUMERO_POSTI; // Ogni automobilista cerca di prenotare un posto diverso
            Thread automobilista = new Thread(new Automobilista(parcheggio, postoDaPrenotare));
            automobilista.start();
        }

    }
}
