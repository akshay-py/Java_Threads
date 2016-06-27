
public class App {

	public static void main(final String[] args) {
		final Runner runner = new Runner();

		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (final InterruptedException e) {

				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (final InterruptedException e) {

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

		runner.finished();

	}

}
