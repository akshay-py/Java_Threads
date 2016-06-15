import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(final String name, final int timeToStart, final CountDownLatch latch) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (final InterruptedException ex) {

		}
		System.out.println(name + " is Up ");
		latch.countDown();
	}

}
