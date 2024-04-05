package ClassiQuarte.AI.Esercizi.ThreadChainWithSequence;

public class Main {
    public static void main(String[] args) {
        ChainThread chainThreadC = new ChainThread("Chain Thread C", null);
        ChainThread chainThreadB = new ChainThread("Chain Thread B", chainThreadC);
        ChainThread chainThreadA = new ChainThread("Chain Thread A", chainThreadB);

        chainThreadA.start();
        chainThreadB.start();
        chainThreadC.start();

        try {
            chainThreadB.join();
            chainThreadA.join();
            chainThreadC.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main chiude.");
    }
}
