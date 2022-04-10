package ie.com.visibleThread.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.com.visibleThread.dtos.FrequencyDTO;
import ie.com.visibleThread.services.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentService docService;
	
	@GetMapping("/getWordFrequency")
	public List<FrequencyDTO> getWordsFrequency(
			@RequestParam(value = "document", required = true) String documentText) {
		
		return docService.getTop10FrequentWords(documentText);
	
	}

}
