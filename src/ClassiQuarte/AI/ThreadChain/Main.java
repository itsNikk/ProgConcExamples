package ClassiQuarte.AI.ThreadChain;

public class Main {
    public static void main(String[] args) {
        ChainThread c = new ChainThread("Thread C", null);
        ChainThread b = new ChainThread("Thread B", c);
        ChainThread a = new ChainThread("Thread A", b);

        a.start();
        b.start();
        c.start();
    }
}
