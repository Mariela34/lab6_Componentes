package com.cenfotec.journal.service;
import java.util.List;
import com.cenfotec.journal.domain.Journal;



public interface JournalService {
	
	
	public void saveJournal(Journal newJournal);
	public List<Journal> getAllJournals();
}
