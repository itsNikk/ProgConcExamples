package ClassiQuarte.AI.Esercizi.GenerazioneEContaDiNumeriCasuali;

public class NumberCounter extends Thread {

    private final NumberGenerator generator;

    public NumberCounter(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        int count = 0;
        int foo = 0;
        while (true) {
            int current = generator.getGeneratedNumber();
            if (current != foo) {
                foo = current;
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
