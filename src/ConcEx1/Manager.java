package ConcEx1;

public class Manager extends Thread {

    private final Pizzaiolo pizzaBoy;

    public Manager(String name, Pizzaiolo p) {
        super(name);
        this.pizzaBoy = p;
    }

    @Override
    public void run() {
        try {
            pizzaBoy.manage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
