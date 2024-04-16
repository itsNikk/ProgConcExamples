package ClassiQuarte.AI.Esercizi.StazioneAlternativeVersion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Binario[] binari = new Binario[4];
        for (int i = 0; i < binari.length; i++) {
            binari[i] = new Binario(i + 1, false);
        }
        Stazione stazione = new Stazione("Porta garibaldi", binari);
        //Stazione stazione1 = new Stazione("asdfhkajsdf",6);

        ArrayList<Treno> treni = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            treni.add(new Treno(i + 1, stazione));
        }

        for (Treno treno : treni) treno.start();
        for (Treno treno : treni) treno.join();

        System.out.println("La stazione chiude :)");
    }
}
