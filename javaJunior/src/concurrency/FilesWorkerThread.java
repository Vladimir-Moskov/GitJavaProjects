package concurrency;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FilesWorkerThread implements Runnable {
	
	private String path;
	private String extension;
	
	public Map<String, Path> filesMap;
	
	public FilesWorkerThread(String path, String extension){
		this.path = path;
		this.extension = extension;
		
		filesMap = new HashMap();
	}
	
	 @Override
    public void run() {
        processJob();
	 }
	 
	 private void processJob(){
			try{
				Path dir = Paths.get(path);
				DirectoryStream ds = Files.newDirectoryStream(dir, extension);
				 for (Object p : ds) {
					 Path path = (Path) p;
					 String filename = path.getFileName().toString();
					 filesMap.put(filename, path);
					 //System.out.println(((Path)p).getFileName());
				 }
			}
			catch(Exception e){
				
			}
	 }
}
