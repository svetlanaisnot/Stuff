import java.util.concurrent.Callable;

/**
 * Created by svetlana on 13/10/14.
 */
public class RobotTwoLegsFuture {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(40);
        for (int i = 0; i < 40; i++) {
            new Thread(new Lapa("Thread" + i, i, monitor)).start();
        }
    }
}

class Lapa implements Runnable {

    private String name;
    private int id;
    private final Monitor monitor;

    public Lapa(String name, int id, Monitor monitor) {
        this.name = name;
        this.id = id;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                while (monitor.getCurrentId() != id) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                doStep();
                monitor.setNextId();
                monitor.notifyAll();
            }
        }
    }

    public void doStep() {
        System.out.println(name + " is going");
    }
}

class Monitor {
    private int currentLapa = 0;
    private int n;

    public Monitor(int n) {
        this.n = n;
    }

    public int getNextId() {
        return (currentLapa + 1) % n;
    }

    public void setNextId() {
        currentLapa = (currentLapa + 1) % n;
    }

    public int getCurrentId() {
        return currentLapa;
    }

}
