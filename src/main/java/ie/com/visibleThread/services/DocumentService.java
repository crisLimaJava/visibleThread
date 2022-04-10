package ie.com.visibleThread.services;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ie.com.visibleThread.components.interfaces.IDocumentService;
import ie.com.visibleThread.dtos.FrequencyDTO;
import ie.com.visibleThread.enums.ExcludedWordsEnum;
import ie.com.visibleThread.exceptions.TextNotPresentException;

@Service
public class DocumentService implements IDocumentService{
	
	private static final String PATTERN_SEARCH = "(?:^|(?<=\\s))[A-Za-z'\\-]+(?=\\s|$|\\b)";
	private static final Integer INCREMENT_FREQUENCY = 1;
	private static final Integer TOP_10_SIZE = 10;
	
	
	/**
	 * If text is present return TOP-10 words frequency
	 * 
	 * If text is NULL or Empty or Black throw TextNotPresentException
	 * 
	 * @param String documentText
	 * @return List<FrequencyDTO>
	 * @exception TextNotPresentException
	 */
	public List<FrequencyDTO> getTop10FrequentWords(String documentText){
		
		if(null == documentText || documentText.isEmpty() || documentText.isBlank())
			throw new TextNotPresentException("Text not present");
		
		Matcher matcher = Pattern.compile(PATTERN_SEARCH).matcher(documentText);
		
		Map<String, Integer> wordsCountedMap = new HashMap<String, Integer>();
		
		while(matcher.find()) {
			
			String word = matcher.group().toLowerCase();
			
			if(ExcludedWordsEnum.getValues().contains(word)) continue;
			
			Optional.ofNullable(wordsCountedMap.get(word))
				.ifPresentOrElse(counter -> wordsCountedMap.put(word, ++counter), 
					() -> wordsCountedMap.put(word, INCREMENT_FREQUENCY));
		}
		
		return FrequencyDTO.convertMapToList(wordsCountedMap).stream()
				.sorted(Comparator.comparing(FrequencyDTO::getFrequency).reversed())
				.limit(TOP_10_SIZE)
				.collect(Collectors.toList());
	}

	

}
