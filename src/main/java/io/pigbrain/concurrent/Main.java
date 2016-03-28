package io.pigbrain.concurrent;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
	private final static ForkJoinPool forkJoinPool = new ForkJoinPool();
    private final static WordCounter wordCounter = new WordCounter();
	
	static Long countOccurrencesInParallel(Folder folder, String searchedWord) {
		return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
	}

	static Long countOccurrencesOnSingleThread(Folder folder, String searchedWord) {
	    long count = 0;
	    for (Folder subFolder : folder.getSubFolders()) {
	        count = count + countOccurrencesOnSingleThread(subFolder, searchedWord);
	    }
	    
	    for (Document document : folder.getDocuments()) {
	        count = count + wordCounter.occurrencesCount(document, searchedWord);
	    }
	    
	    return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		final String filePath = "./"; //
		final String word = "find"; // 
		
	    Folder folder = Folder.fromDirectory(new File(filePath));
	    
	    {
	    	long startTime = System.currentTimeMillis();
	    	System.out.println(countOccurrencesInParallel(folder, word));
	    	long endTime = System.currentTimeMillis();
	    	System.out.println("search time in parallel Thread : " + (endTime - startTime));
	    }
	    
	    {
	    	long startTime = System.currentTimeMillis();
		    System.out.println(countOccurrencesOnSingleThread(folder, word));
	    	long endTime = System.currentTimeMillis();
	    	System.out.println("search time in single Thread : " + (endTime - startTime));
	    }	    
	    
	}
}
