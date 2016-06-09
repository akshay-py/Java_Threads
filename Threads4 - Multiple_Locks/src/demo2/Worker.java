package demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private final Random random = new Random();

	private final List<Integer> list1 = new ArrayList<Integer>();
	private final List<Integer> list2 = new ArrayList<Integer>();

	public synchronized void stageOne() {
		try {
			Thread.sleep(1);
		} catch (final InterruptedException e) {

		}
		list1.add(random.nextInt(100));
	}

	public synchronized void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (final InterruptedException e) {

		}
		list2.add(random.nextInt(100));
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Starting...");

		final long start = System.currentTimeMillis();

		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});

		final Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (final InterruptedException e) {
		}
		final long end = System.currentTimeMillis();

		System.out.println("Time taken -> " + (end - start));

		System.out.println("List1 size -> " + list1.size() + ", List2 size -> " + list2.size());
	}

}
