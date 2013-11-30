package nio2;

import java.io.IOException;

public class DirWatcherDemo {

	public static void main(String[] args) {
		
		try{
			DirWatcher dirWatcher = new DirWatcher("C:/Users/vavas/Downloads", false);
			dirWatcher.startWatching();
		}
		catch(IOException ioe){
			 System.out.println("DirWatcherDemo - IOException!");
		}

	}

}
