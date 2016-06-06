package demo1;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {

			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(final String[] args) {
		final Processor proc1 = new Processor();
		proc1.start();

		System.out.println("Press return to stop");
		final Scanner scan = new Scanner(System.in);
		scan.nextLine();

		proc1.shutdown();
	}

}
