package ClassiQuarte.AI.Esercizi.GenerazioneEContaDiNumeriCasuali;

import java.util.Random;

public class NumberGenerator extends Thread {

    private Random random = new Random();
    private int generatedNumber;

    @Override
    public void run() {
        while (true) {
            generatedNumber = random.nextInt(1, 100);
            System.out.println("Numero generato: " + generatedNumber);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                break;
            }
        }
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }
}
