package demo1;

public class App {

	public static void main(final String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (final InterruptedException ignored) {
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (final InterruptedException ignored) {
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
