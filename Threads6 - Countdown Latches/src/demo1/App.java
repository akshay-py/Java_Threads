package demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {

	private final CountDownLatch latch;

	Processor(final CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting...");

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {

		}

		latch.countDown();
	}

}

public class App {

	public static void main(final String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		final ExecutorService service = Executors.newFixedThreadPool(3);

		for (int i = 0; i <= 3; i++) {
			service.submit(new Processor(latch));
		}

		try {
			latch.await();
		} catch (final InterruptedException e) {

		}

		System.out.println("Completed... ");
	}

}
