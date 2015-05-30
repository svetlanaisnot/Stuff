/**
 * Created by svetlana on 12/10/14.
 */
public class RobotTwoLegsWaitNotify {
    public static void main(String[] args) {
        boolean isLeft = true;
        BooleanWrapper wrapper = new BooleanWrapper();
        new Thread(new Leg("left", isLeft, wrapper)).start();
        new Thread(new Leg("right", !isLeft, wrapper)).start();
    }

}

class Leg implements Runnable {

    private String name;
    private boolean isLeft;
    private BooleanWrapper isLeftWorking;

    public Leg(String name, boolean isLeft, BooleanWrapper wrapper) {
        this.name = name;
        this.isLeft = isLeft;
        this.isLeftWorking = wrapper;
    }

    private void doStep() {
        System.out.println(name + " is going");
    }

    private void doLeftStep() throws InterruptedException {
        synchronized (isLeftWorking) {
            while (!isLeftWorking.getValue()) {
                isLeftWorking.wait();
            }
            doStep();
            isLeftWorking.setValue(false);
            isLeftWorking.notifyAll();
        }

    }

    private void doRightStep() throws InterruptedException {
        synchronized (isLeftWorking) {
            while (isLeftWorking.getValue()) {
                isLeftWorking.wait();
            }
            doStep();
            isLeftWorking.setValue(true);
            isLeftWorking.notifyAll();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (isLeft) {
                    doLeftStep();
                } else {
                    doRightStep();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Thread " + name + " interrupted");
        }
    }
}

class BooleanWrapper {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
