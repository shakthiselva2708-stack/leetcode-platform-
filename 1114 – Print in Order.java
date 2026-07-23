class Foo {

    private int turn = 1;

    public Foo() {
    }

    public synchronized void first(Runnable printFirst) {

        printFirst.run();
        turn = 2;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        while (turn != 2) {
            wait();
        }

        printSecond.run();
        turn = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        while (turn != 3) {
            wait();
        }

        printThird.run();
    }
}
