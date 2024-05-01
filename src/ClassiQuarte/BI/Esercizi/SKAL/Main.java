package ClassiQuarte.BI.Esercizi.SKAL;

public class Main {
    public static void main(String[] args) {
        WineBarrel wineBarrel = new WineBarrel(3, 1);
        final int numDrinkers = 10;

        WineDrinker[] drinkers = new WineDrinker[numDrinkers];

        for (int i = 0; i < numDrinkers; i++) {
            drinkers[i] = new WineDrinker("Bevitore " + (i + 1), wineBarrel);
            drinkers[i].start();
        }
    }
}
