package ClassiQuarte.BI.Esercizi.GenerazioneEContaDiNumeriCasuali;

public class NumberCounter extends Thread {

    private final NumberGenerator generator;

    public NumberCounter(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        int count = 0;
        int lastNumber = 0;
        while (true) {
            int numberFromGeneratorThread = generator.getGeneratedNumber();
            if (numberFromGeneratorThread != lastNumber) {
                lastNumber = numberFromGeneratorThread;
                count++;
                System.out.println("Numeri contati: " + count);
            }
            try {
                sleep(1100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
