package demo1;

public class App {

	public static void main(final String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		final Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (final InterruptedException ignored) {
				}
			}
		});

		final Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (final InterruptedException ignored) {
				}
			}
		});

		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
}
