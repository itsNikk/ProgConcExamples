package ClassiQuarte.BI.Intro;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);

        System.out.println(t.getName());
        t.setName("Il mio main");
        System.out.println(t);

        t.setPriority(8);
        System.out.println(t);
        //t.setPriority(12);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);

    }
}
