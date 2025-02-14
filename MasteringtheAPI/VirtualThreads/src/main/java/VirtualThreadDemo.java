import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        /* 1.Creating Virtual Threads

   public class VirtualThreadDemo {
   public static void main(String[] args) {
     final int NTASKS = 100;
     ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
      for (int i = 0; i < NTASKS; i++) {
         service.submit(() -> {
            long id = Thread.currentThread().threadId();
            LockSupport.parkNanos(1_000_000_000);
            System.out.println(id);
         });
      }
      service.close();
   }
}

        -Builder to create a single virtual thread:
        Thread.Builder builder = Thread.ofVirtual().name("request-", 1);
        Thread t = builder.started(() -> System.out.println("Running a virtual thread"));

        -Start the thread right away:
        Thread t = builder.started(myRunnable);

        -Convenience method to start a virtual thread quickly:
        Thread t = Thread.startVirtualThread(() -> System.out.println("Hello, Virtual Thread!"));

        2. Thread API Changes
        -Virtual Threads behave like regular Thread instances.
        -Interruptions work the same way (by checking Thread.interrupted()).

         -All virtual threads:
            Belong to a single thread group.
            Have priority NORM_PRIORITY.
            Are daemon threads (terminate when all platform threads stop).
         -Methods that have no effect on virtual threads:
            setPriority()
            setDaemon()
         -New method: Thread::isVirtual() to check if a thread is virtual.


          3.Capturing Task Results:

public class VirtualThreadDemo {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
      Future<String> f1 = service.submit(() -> get("https://horstmann.com/random/adjective"));
      Future<String> f2 = service.submit(() -> get("https://horstmann.com/random/noun"));
      String result = f1.get() + " " + f2.get();
      System.out.println(result);
      service.close();
   }

   private static HttpClient client = HttpClient.newHttpClient();

   public static String get(String url) {
      try {
         var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
         return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
      } catch (Exception ex) {
         var rex = new RuntimeException();
         rex.initCause(ex);
         throw rex;
      }
   }
}






         */
    }




}

