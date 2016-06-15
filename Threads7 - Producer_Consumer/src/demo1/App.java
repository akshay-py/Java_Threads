package demo1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	private final static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(final String[] args) {
		final Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (final InterruptedException e) {

				}
			}
		});

		final Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer();
				} catch (final InterruptedException e) {

				}
			}
		});

		producer.start();
		consumer.start();

		try {
			producer.join();

			consumer.join();

		} catch (final InterruptedException e) {

		}

	}

	private static void producer() throws InterruptedException {
		final Random random = new Random();

		while (true) {
			queue.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		final Random random = new Random();

		while (true) {

			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				final Integer value = queue.take();
				System.out.println("Taken value..  " + value + "... queue size.." + queue.size());
			}
		}
	}

}
