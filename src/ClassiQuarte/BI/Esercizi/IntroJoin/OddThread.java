package ClassiQuarte.BI.Esercizi.IntroJoin;

public class OddThread extends Thread {

    public OddThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) System.out.println(getName() + ": " + i);
        }
    }
}
