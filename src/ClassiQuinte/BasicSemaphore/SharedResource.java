package ClassiQuinte.BasicSemaphore;

public class SharedResource {

    private long counter;

    public synchronized void Add(long value) {
        counter += value;
    }

    public synchronized void Double() {
        counter *= 2;
    }

    public synchronized void Subtract(long val) { counter -= val;}

    public long GetCounter() {
        return counter;
    }
}
