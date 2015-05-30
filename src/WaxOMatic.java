import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by svetlana on 09/10/14.
 */
public class WaxOMatic {
    class Car {
        private boolean waxOn = false;

        public synchronized void waxed() {
            waxOn = true;
            notifyAll();
        }

        public synchronized void buffed() {
            waxOn = false;
            notifyAll();
        }

        public synchronized void waitFoWaxing() throws InterruptedException {
            while (!waxOn) {
                wait();
            }
        }

        public synchronized void waitForBuffing() throws InterruptedException {
            while (waxOn) {
                wait();
            }
        }


    }
    class WaxOn implements Runnable {

        private Car car;
        public WaxOn(Car car) {
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    System.out.println("Wax On!");
                    TimeUnit.MILLISECONDS.sleep(20);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch (InterruptedException ex) {
                System.out.println("WaxOn interrupt");
            }
            System.out.println("End wax on task");
        }
    }

    class WaxOff implements Runnable {

        private Car car;
        public WaxOff(Car car) {
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitFoWaxing();
                    System.out.println("Wax Off!");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            }  catch (InterruptedException ex) {
                System.out.println("WaxOff interrupt");
            }
            System.out.println("End wax off task");
        }
    }

    public static void main(String[] args) throws Exception {
        WaxOMatic wmatic = new WaxOMatic();
        wmatic.go();

    }

    public void go() throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(20);
        exec.shutdown();
    }
}
