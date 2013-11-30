package concurrency.synchronization.lock;

public class Main {
	
	public static void main(String[] args) {
		FileMock mock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		
		Producer producer = new Producer(mock, buffer);
		Thread threadProducer = new Thread(producer, "Producer");
		
		Consumer consumers[] = new Consumer[3];
		Thread threadConsumers[] = new Thread[3];
		for (int i=0; i<3; i++){
			consumers[i] = new Consumer(buffer);
			threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
		}
		
		threadProducer.start();
		for (int i=0; i<3; i++){
			threadConsumers[i].start();
		}
	}
	
	public static void main_0(String[] args) {
		PricesInfo pricesInfo = new PricesInfo();
		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];
		
		for (int i=0; i<5; i++){
			readers[i] = new Reader(pricesInfo);
			threadsReader[i] = new Thread(readers[i]);
		}
		
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		
		for (int i=0; i<5; i++){
			threadsReader[i].start();
		}
		threadWriter.start();
		
	}
	
	public static void main_1(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[10];
		
		for (int i=0; i<10; i++){
			thread[i] = new Thread(new Job(printQueue),"Thread "+ i);
		}

		
		for (int i=0; i<10; i++){
			thread[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
