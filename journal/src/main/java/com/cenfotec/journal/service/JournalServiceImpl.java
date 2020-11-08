package com.cenfotec.journal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.journal.domain.Journal;
import com.cenfotec.journal.repository.JournalRepository;


@Service
public class JournalServiceImpl implements JournalService {
		
		@Autowired
		JournalRepository journalRepo;
		@Override
		public void saveJournal(Journal newJournal) {
		journalRepo.save(newJournal);
		}
		@Override
		public List<Journal> getAllJournals() {
		return journalRepo.findAll();
		}
		
		
		
}
