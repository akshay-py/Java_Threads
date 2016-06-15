package demo1;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private final LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private final Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {

				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		final Random random = new Random();

		while (true) {
			synchronized (lock) {

				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is.. " + list.size());
				final int value = list.removeFirst();
				System.out.println("; value.. " + value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}
