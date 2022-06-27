public class Main {

    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        Thread[] threads = new Thread[4];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(threadGroup, ("поток " + (i + 1)));
            threads[i].start();
        }

        try {
            Thread.sleep(15_000);
        } catch (InterruptedException err) {
        }
        System.out.println("Завершаю все потоки.");
        threadGroup.interrupt();
    }
}
