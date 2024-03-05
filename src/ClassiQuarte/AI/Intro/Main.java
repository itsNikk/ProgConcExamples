package ClassiQuarte.AI.Intro;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Thread corrente: " + t);
        t.setName("Il mio main");
        System.out.println("Thread corrente: " + t);
        System.out.println("Nome Thread corrente: " + t.getName());

        t.setPriority(7);
        System.out.println("Thread corrente: " + t);
        System.out.println("Min priority: " + Thread.MIN_PRIORITY);
        System.out.println("Max priority: " + Thread.MAX_PRIORITY);
        System.out.println("Norm priority: " + Thread.NORM_PRIORITY);

    }
}
