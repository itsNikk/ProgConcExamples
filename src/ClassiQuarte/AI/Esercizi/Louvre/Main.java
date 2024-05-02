package ClassiQuarte.AI.Esercizi.Louvre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Museum museum = new Museum();
        final int NUM_TOURISTS = 50;

        ArrayList<Tourist> tourists = new ArrayList<>();
        //Riempire AL con threads
        for (int i = 0; i < NUM_TOURISTS; i++) {
            tourists.add(new Tourist("Turista#" + (i + 1), museum));
        }

        // avvia tutti i turisti :)
        // Per ogni Tourist nell'ArrayList tourists...
        for (Tourist t : tourists) {
            t.start();
        }

        //Fai chiudere il main per ultimo...
        for (Tourist tourist : tourists) {
            tourist.join();
        }

        System.out.println("Il main chiude.");
    }
}
