package ConcEx1;

public class Cliente extends Thread {

    private final Pizzaiolo pizzaBoy;

    public Cliente(Pizzaiolo p) {
        super("Cliente");
        this.pizzaBoy = p;
    }

    @Override
    public void run() {
        int pizzaTime = 5000;
        try {
            pizzaBoy.orderPizza(pizzaTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + ": Nom nom nom...");
    }
}
