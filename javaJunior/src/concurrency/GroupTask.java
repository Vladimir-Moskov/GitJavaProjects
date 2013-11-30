package concurrency;

import java.util.Random;

public class GroupTask implements Runnable {
	@Override
	public void run() {
		int result;
		Random random=new Random(Thread.currentThread().getId());
	    while (true) {
			result=1000/((int)(random.nextDouble()*1000));
			System.out.printf("%s : %f\n",Thread.currentThread().getId(),result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return;
			}
		}
	}
}
