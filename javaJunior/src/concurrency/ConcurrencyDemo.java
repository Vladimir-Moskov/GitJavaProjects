package concurrency;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class ConcurrencyDemo {

	public static void main(String[] args) {
		FilesWorkerThread fileWorker1 = new FilesWorkerThread("C:/Users/vavas/Downloads", "*.pdf");
		FilesWorkerThread fileWorker2 = new FilesWorkerThread("C:/Users/vavas/Downloads", "*.txt");
		FilesWorkerThread fileWorker3 = new FilesWorkerThread("C:/Users/vavas/Downloads", "*.doc");
		FilesWorkerThread fileWorker4 = new FilesWorkerThread("C:/Users/vavas/Downloads", "*.png");
		FilesWorkerThread fileWorker5 = new FilesWorkerThread("C:/Users/vavas/Downloads", "*.jpg");
		
		FileWorkerExecutor executor = new FileWorkerExecutor(2);
		Map<String, Path> filesMap = executor.execute(Arrays.asList(fileWorker1, fileWorker2, fileWorker3, fileWorker4, fileWorker5));
       
		System.out.println("Finished all threads");
        System.out.println("***");
        System.out.println(filesMap);
	}

}
