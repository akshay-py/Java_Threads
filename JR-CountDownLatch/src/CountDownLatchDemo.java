import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(final String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		final Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		final Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		final Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start();
		alertService.start();
		validationService.start();

		try {
			latch.await();
			System.out.println("All services are up..");
		} catch (final InterruptedException iex) {

		}
	}

}
