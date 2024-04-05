package ClassiQuarte.BI.Esercizi.IntroduzioneJoin;

public class OddPrinterThread extends Thread {

    public OddPrinterThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(getName() + ": " + i);
        }
    }
}
