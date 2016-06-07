package demo2;

// Synchronized

public class App {

	private int count = 0;

	public static void main(final String[] args) {
		final App app = new App();
		app.doWork();
	}

	public void doWork() {
		final Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					incrementCount();

					System.out.println("Thread -> " + Thread.currentThread().getName() + " Count -> " + count);
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					incrementCount();

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

	synchronized public void incrementCount() {
		count++;
	}
}
