package demo1;

import java.util.concurrent.atomic.AtomicInteger;

// AtomicInteger

public class App {

	private final AtomicInteger count = new AtomicInteger(0);

	public static void main(final String[] args) {
		final App app = new App();
		app.doWork();
	}

	public void doWork() {
		final Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					count.incrementAndGet();

					System.out.println("Thread -> " + Thread.currentThread().getName() + " Count -> " + count);
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					count.incrementAndGet();

					System.out.println("Thread -> " + Thread.currentThread().getName() + " Count -> " + count);
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (final InterruptedException e) {

		}

		//System.out.println("Count -> " + count);
	}
}
