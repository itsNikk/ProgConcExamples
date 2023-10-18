package Orario;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new Orario("17:23pm"));
        } catch (OrarioException e) {
            System.out.println(e.getMessage());
        }
    }
}
