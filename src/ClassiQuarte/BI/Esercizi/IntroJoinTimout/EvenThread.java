package ClassiQuarte.BI.Esercizi.IntroJoinTimout;

public class EvenThread extends Thread {

    public EvenThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            if (i % 2 == 0) System.out.println(getName() + ": " + i);
        }
    }
}
