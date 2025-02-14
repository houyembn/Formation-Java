import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class PinningDem {
  /*   Pinning
-Virtual threads are mounted on platform threads (carrier threads).
-Blocking operations should unmount virtual threads, but some situations cause pinning:
1/Synchronized blocks/methods
2/Native methods or foreign function calls
-When pinned, a virtual thread cannot be unmounted, potentially blocking all carrier threads.
-Solutions:
-Replace synchronized with ReentrantLock where possible.
-Use -Djdk.tracePinnedThreads=short/full or Java Flight Recorder to detect pinning issues.



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service =
                Executors.newVirtualThreadPerTaskExecutor();
        // Executors.newCachedThreadPool();

        final int TASKS = 20;
        long start = System.nanoTime();
        for (int i = 1; i <= TASKS; i++) {
            service.submit(() -> block());
            // service.submit(() -> rblock());
        }
        for (int i = 1; i <= TASKS; i++) {
            service.submit(() -> noblock());
        }
        service.close();
        long end = System.nanoTime();
        System.out.printf("%.2f%n", (end - start) * 1E-9);
    }

    public static synchronized void block() {
        System.out.println("Entering block " + Thread.currentThread());
        LockSupport.parkNanos(1_000_000_000);
        System.out.println("Exiting block " + Thread.currentThread());
    }
    private static Lock lock = new ReentrantLock();
    public static void rblock() {
        lock.lock();
        try {
            System.out.println("Entering rblock " + Thread.currentThread());
            LockSupport.parkNanos(1_000_000_000);
            System.out.println("Exiting rblock " + Thread.currentThread());
        } finally {
            lock.unlock();
        }
    }
    public static void noblock() {
        System.out.println("Entering noblock " + Thread.currentThread());
        LockSupport.parkNanos(1_000_000_000);
        System.out.println("Exiting noblock " + Thread.currentThread());
    }*/
}
