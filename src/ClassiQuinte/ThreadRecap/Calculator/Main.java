package ClassiQuinte.ThreadRecap.Calculator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        AdderThread a1 = new AdderThread(c);
        AdderThread a2 = new AdderThread(c);
        AdderThread a3 = new AdderThread(c);
        AdderThread a4 = new AdderThread(c);

        SubtractThread s1 = new SubtractThread(c);
        SubtractThread s2 = new SubtractThread(c);

     /*   a1.start();
        a2.start();
        a3.start();
        a4.start();
*/
        s1.start();
        s2.start();

        a1.join();
        a2.join();
        a3.join();
        a4.join();

        s1.join();
        s2.join();

        System.out.println(c.getCounter());
    }
}
