package demo2;

class Runner implements Runnable {

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

	public static void main(final String[] args) {
		final Thread t1 = new Thread(new Runner());
		final Thread t2 = new Thread(new Runner());
		t1.start();
		t2.start();
	}

}
