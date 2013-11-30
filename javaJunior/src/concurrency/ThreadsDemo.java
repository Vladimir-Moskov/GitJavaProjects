package concurrency;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class ThreadsDemo {
	
	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		GroupTask task = new GroupTask();
		
		for (int i = 0; i < 2; i++){
			Thread t = new Thread(threadGroup,task);
			t.start();
		}
	}
	
	public static void main_8(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();
		
		Thread[] threads=new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i<threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n",threads[i].
					getName(),threads[i].getState());
		}
		
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main_7(String[] args) {
		//UnsafeTask task=new UnsafeTask();
		SafeTask task=new SafeTask();
		
		for (int i = 0; i < 10; i++){
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main_6(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
	
	public static void main_5(String[] args) {
		
		Deque<Event> deque = new ArrayDeque<Event>() ;
		WriterTask writer = new WriterTask(deque);
		for (int i=0; i < 3; i++){
			Thread thread=new Thread(writer);
			thread.start();
		}
		
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.setDaemon(true);
		cleaner.start();
	}
	
	public static void main_4(String[] args) {
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread dataSourceThread = new Thread(dsLoader,"DataSourceThread");
		
		NetworkConnectionsLoader ncLoader = new	NetworkConnectionsLoader();
		Thread networkConnectionThread = new Thread(ncLoader,"NetworkConnectionThread");
		
		dataSourceThread.start();
		networkConnectionThread.start();
		
		try {
			dataSourceThread.join();
			networkConnectionThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Configuration has been loaded:	%s\n", new Date());
	}
	
	public static void main_3(String[] args) {
		FileClock clock=new FileClock();
		Thread thread=new Thread(clock);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		
		thread.interrupt();
	}
	
	public static void main_2(String[] args) {
		FileSearch searcher=new FileSearch("C:\\","BOOTSECT.BAK");
		Thread thread=new Thread(searcher);
		thread.start();
		 
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}
	
	public static void main_1(String[] args) {
		
		Thread task = new PrimeGenerator();
		task.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		task.interrupt();
	}
	
	public static void main_0(String[] args) {
	
		Thread threads[]=new Thread[10];
		Thread.State status[]=new Thread.State[10];
		
		for (int i=0; i<10; i++){
			threads[i]=new Thread(new CalculatorRunnable(i));
			if ((i%2) == 0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread___" + i );
		}
		
		PrintWriter pw;
		
		try {
			FileWriter file = new FileWriter("log_Demo.txt");
			pw = new PrintWriter(file);
			for (int i=0; i<10; i++){
				pw.println("Main : Status of Thread "+i+" : " +	threads[i].getState());
				status[i] = threads[i].getState();
			}
			
			for (int j=0; j<10; j++){
				threads[j].start();
			}
			
			boolean finish=false;
			while (!finish) {
				for (int i=0; i<10; i++){
					if (threads[i].getState()!=status[i]) {
						writeThreadInfo(pw, threads[i],status[i]);
						status[i]=threads[i].getState();
					}
				}
				finish=true;
				for (int i=0; i<10; i++){
					finish=finish &&(threads[i].getState()==State.TERMINATED);
				}
			}
			pw.close();
		}
		catch(Exception error){
			System.out.println(error);
		}
		//finally{
		//	pw.close();
		//}
				
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
			pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
			pw.printf("Main : Priority: %d\n",thread.getPriority());
			pw.printf("Main : Old State: %s\n",state);
			pw.printf("Main : New State: %s\n",thread.getState());
			pw.printf("Main : ************************************\n");
	}
}
