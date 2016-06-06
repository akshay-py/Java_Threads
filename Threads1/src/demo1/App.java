package demo1;

class Runner extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello... " + i + "... " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {

			}
		}
	}
}

public class App {
	public static void main(final String args[]) {
		final Runner run1 = new Runner();
		run1.start();

		final Runner run2 = new Runner();
		run2.start();
	}
}
