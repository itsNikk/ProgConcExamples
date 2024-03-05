package ClassiQuinte.ConcEx1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Pizzaiolo p = new Pizzaiolo();

        new Manager("Manager", p).start();
        Thread.sleep(3000);
        Cliente c = new Cliente(p);
        c.start();

    }
}
