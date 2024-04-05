package ClassiQuarte.AI.ThreadChain;

public class Main {
    public static void main(String[] args) {
        ChainThread a = new ChainThread("Thread A", null);
        ChainThread b = new ChainThread("Thread B", a);
        ChainThread c = new ChainThread("Thread C", b);

        a.start();
        b.start();
        c.start();
    }
}
