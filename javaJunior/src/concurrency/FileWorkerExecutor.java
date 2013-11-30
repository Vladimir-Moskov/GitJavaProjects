package concurrency;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileWorkerExecutor {
	private ExecutorService executor;
	
	public FileWorkerExecutor(int maxThreads){
		executor = Executors.newFixedThreadPool(maxThreads);
	}

	public Map<String, Path> execute(List<FilesWorkerThread> listThreads){
		Map<String, Path> resultMap = new HashMap<String, Path>();
		if(listThreads != null){
			for(FilesWorkerThread fwt: listThreads){
				  executor.execute(fwt);
			}
			executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        for(FilesWorkerThread fwt: listThreads){
	        	resultMap.putAll(fwt.filesMap); 
			}
		}
		System.out.println("Finished all threads");
		
		return resultMap;
	}
}
