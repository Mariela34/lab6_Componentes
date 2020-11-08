package com.cenfotec.journal.web;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cenfotec.journal.domain.Journal;
import com.cenfotec.journal.service.JournalService;


@Controller
public class JournalController {
	@Autowired
	JournalService journalService;
	
	@RequestMapping("/")
	public String index(Model model) throws ParseException {
		model.addAttribute("journal", journalService.getAllJournals());
		Journal newEntry = new Journal("Hola Mundo", "un saludo", "07/15/2017");
		journalService.saveJournal(newEntry);
		return "index";
	}
	
	@GetMapping("/postJournal")
	public String formJournal(Model model) throws ParseException {
		model.addAttribute("journal", new Journal());
		return "formJournal";
	}
	
	@PostMapping("/postJournal")
	public String postJournal(@ModelAttribute Journal journal, Model model) throws ParseException{
		model.addAttribute("journal", journal);
		journalService.saveJournal(journal);
		return "result";
	}
	
	@RequestMapping(value="/journals", method=RequestMethod.GET)
	public String listJournals(Model model) {
		model.addAttribute("journals", journalService.getAllJournals());
		List<Journal> lista = journalService.getAllJournals();
		return "listJournals";
	}
	
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewJournal(Model model, @PathVariable("id") Optional<Long> id)
	{
		if (id.isPresent()) {
            Journal journal = journalService.getJournal(id.get());
            model.addAttribute("journal", journal);
        } else {
            model.addAttribute("journal", new Journal());
        }
		return "journal";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
