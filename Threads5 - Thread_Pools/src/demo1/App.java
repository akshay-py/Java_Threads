package demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	int id;

	public Processor(final int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting... " + id);

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {

		}
		System.out.println("Completed.. " + id);
	}

}

public class App {

	public static void main(final String[] args) {
		final ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i <= 4; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted..");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (final InterruptedException e) {

		}

		System.out.println("All tasks completed..");
	}

}
