package edu.mednikov.multithreading;

public class SimpleSteppingRobot implements SteppingRobot {

    private final Object sync = new Object();

    private Thread thread1;
    private Thread thread2;

    @Override
    public void start() {

        thread1 = new Thread(this::stepLeftFoot);
        thread2 = new Thread(this::stepRightFoot);

        thread1.start();
        thread2.start();
    }

    @Override
    public void stop() {
        thread1.interrupt();
        thread2.interrupt();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void stepLeftFoot() {
        stepFoot(true);
    }

    private void stepRightFoot() {
        stepFoot(false);
    }


    private void stepFoot(boolean isLeft) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (sync) {
                    System.out.println(isLeft ? "Left step..." : "Right step...");

                    sync.notify();

                    Thread.sleep(1000L);

                    sync.wait();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("stepFoot(isLeft = %s) was interrupted..." + System.lineSeparator(), isLeft);
        }
    }
}
