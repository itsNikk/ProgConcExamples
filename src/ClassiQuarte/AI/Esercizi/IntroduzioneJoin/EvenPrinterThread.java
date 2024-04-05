package ClassiQuarte.AI.Esercizi.IntroduzioneJoin;

public class EvenPrinterThread extends Thread {

    public EvenPrinterThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(getName() + ": " + i);
        }
    }
}
