import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
//        Thread[] threads = new Thread[4];
//
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new MyThread(threadGroup, ("поток " + (i + 1)));
//            threads[i].start();
//        }
//
//        try {
//            Thread.sleep(15_000);
//        } catch (InterruptedException err) {
//        }
//        System.out.println("Завершаю все потоки.");
//        threadGroup.interrupt();

        int nThreads = 4;

        MyCallable myCallable = new MyCallable();
        List<MyCallable> tasks = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < nThreads; i++) {
            tasks.add(myCallable);
        }

        System.out.println("invokeAny. Кол-во выведенных в консоль сообщений " + executorService.invokeAny(tasks));

        for (Future<Integer> task :
                executorService.invokeAll(tasks)) {
            System.out.println("invokeAll. Кол-во выведенных в консоль сообщений " + task.get());
        }
        System.out.println("Завершаю все потоки.");
        executorService.shutdown();
    }
}
