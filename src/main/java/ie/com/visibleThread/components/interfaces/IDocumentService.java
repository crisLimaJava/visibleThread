package ie.com.visibleThread.components.interfaces;

import java.util.List;

import ie.com.visibleThread.dtos.FrequencyDTO;

public interface IDocumentService {
	
	public List<FrequencyDTO> getTop10FrequentWords(String documentText);

}
