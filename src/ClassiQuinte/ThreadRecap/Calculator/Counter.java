package ClassiQuinte.ThreadRecap.Calculator;

public class Counter {
    private int val;

    public synchronized void Add(int v) {
        val += v;
    }

    public synchronized void Subtract(int v) {
        val -= v;
    }

    public int getCounter(){
        return val;
    }
}
