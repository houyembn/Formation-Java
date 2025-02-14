public class RateLimitDemo {

    /*Rate Limiting:
    Rate limiting is a technique used to control the number of requests or actions that can be made to a service or system within a specific time period.





    public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
      List<Future<String>> futures = new ArrayList<>();
      final int TASKS = 250;
      for (int i = 1; i <= TASKS; i++)
         futures.add(service.submit(() -> get("https://horstmann.com/random/word")));
      for (Future<String> f : futures)
         System.out.print(f.get() + " ");
      System.out.println();
      service.close();
   }

   private static HttpClient client = HttpClient.newHttpClient();

   private static final Semaphore SEMAPHORE = new Semaphore(20);

   public static String get(String url) {
      try {
         var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
         SEMAPHORE.acquire();
         try {
            Thread.sleep(100);
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
         } finally {
            SEMAPHORE.release();
         }
      } catch (Exception ex) {
         ex.printStackTrace();
         var rex = new RuntimeException();
         rex.initCause(ex);
         throw rex;
      }
   }
     */
}
