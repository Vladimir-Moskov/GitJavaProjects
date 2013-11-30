package nio2;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;
import static java.nio.file.LinkOption.*;

import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Example to watch a directory (or tree) for changes to files.
 */

public class DirWatcher {
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
    private final WatchService watcher;
    private final Map<WatchKey,Path> keys;
    private final boolean recursive;
    private boolean trace = false;
  //  private Map<WatchKey,Path>
    private HashMap<String, DosFileAttributes> filesMap;
    
    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }

    /**
     * Register the given directory with the WatchService
     */
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
                }
            }
        }
        keys.put(key, dir);
    }

    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException
            {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Creates a WatchService and registers the given directory
     */
    public DirWatcher(String path, boolean recursive) throws IOException {
        
    	FileHandler fileTxt = new FileHandler("Logs.txt");
    	SimpleFormatter formatterTxt = new SimpleFormatter();
    	fileTxt.setFormatter(formatterTxt);
    	LOGGER.addHandler(fileTxt);

        // register directory and process its events
    	Path dir = Paths.get(path);
        File folder = dir.toFile();
        File[] listOfFiles = folder.listFiles();
        filesMap = new HashMap<String, DosFileAttributes>();
        for(File file: listOfFiles){
        	 DosFileAttributes  atr = Files.readAttributes(file.toPath(), DosFileAttributes.class);
        	 filesMap.put(file.getAbsolutePath(), atr);
        }

    	this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey,Path>();
        this.recursive = recursive;

        if (recursive) {
            System.out.format("Scanning %s ...\n", dir);
            registerAll(dir);
            System.out.println("Done.");
        } else {
            register(dir);
        }

        // enable trace after initial registration
        this.trace = true;
    }

    /**
     * Process all events for keys queued to the watcher
     */
    public void startWatching() {
        for (;;) {

            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    continue;
                }

                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = cast(event);
                Path name = ev.context();
                Path child = dir.resolve(name);
                String absPath = child.toFile().getAbsolutePath();
                LOGGER.info("Event kind = " + event.kind() + " for file = " + child.getFileName());
               
                if(kind == ENTRY_CREATE){
                	try{
                		filesMap.put(absPath, Files.readAttributes(child, DosFileAttributes.class));
                	}
                	catch(IOException e){
                     	
                    }
                }
                else if(kind == ENTRY_DELETE){
                	filesMap.remove(absPath);
                }
                else if(kind == ENTRY_MODIFY){
                	 try{
                		DosFileAttributes oldAtr = filesMap.get(absPath);
                     	if(oldAtr != null){
                     		DosFileAttributes atr = Files.readAttributes(child, DosFileAttributes.class);
                     		if((atr.isArchive() != oldAtr.isArchive()) ||
                     			(atr.isHidden() != oldAtr.isHidden()) ||
                     			(atr.isReadOnly() != oldAtr.isReadOnly())){
                     			
                     				filesMap.put(absPath, atr);
                     				LOGGER.info("Attribute was changed for file = " + absPath);
                     		}
                     
                     	}
                     }
                     catch(IOException e){
                     	
                     }
                }
               
                // print out event
                System.out.format("%s: %s\n", event.kind().name(), child);

                // if directory is created, and watching recursively, then
                // register it and its sub-directories
                if (recursive && (kind == ENTRY_CREATE)) {
                    try {
                        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                            registerAll(child);
                        }
                    } catch (IOException x) {
                        // ignore to keep sample readbale
                    }
                }
            }

            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);

                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
}
