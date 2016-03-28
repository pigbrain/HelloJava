package io.pigbrain.concurrent;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class WordCounter {
	
	private String[] wordsIn(String line) {
		return line.trim().split("(\\s|\\p{Punct})+");
	}

	public Long occurrencesCount(Document document, String searchedWord) {
		long count = 0;
		for (String line : document.getLines()) {
			for (String word : wordsIn(line)) {
				if (searchedWord.equals(word)) {
					count = count + 1;
				}
			}
		}
		return count;
	}
	
	
}
