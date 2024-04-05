package ClassiQuarte.BI.Esercizi.GenerazioneEContaDiNumeriCasuali;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGeneratorThread = new NumberGenerator();
        NumberCounter numberCounterThread = new NumberCounter(numberGeneratorThread);

        numberGeneratorThread.start();
        numberCounterThread.start();
    }
}
