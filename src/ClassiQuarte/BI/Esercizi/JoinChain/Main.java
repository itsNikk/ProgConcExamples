package ClassiQuarte.BI.Esercizi.JoinChain;

public class Main {
    public static void main(String[] args) {
        ChainThread threadC = new ChainThread("Thread C", null);
        ChainThread threadB = new ChainThread("Thread B", threadC);
        ChainThread threadA = new ChainThread("Thread A", threadB);

        threadA.start();
        threadC.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrotto.");
            return;
        }

        System.out.println("Main conclude.");

    }
}
