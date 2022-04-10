package ie.com.visibleThread.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrequencyDTO {

	private String word;

	private Integer frequency;
	

	public int compareTo(FrequencyDTO frequency) {
		return this.frequency.compareTo(frequency.getFrequency()) == 0 ?
				this.word.compareTo(frequency.getWord()) : this.frequency.compareTo(frequency.getFrequency());
	}
	
	public static List<FrequencyDTO> convertMapToList(Map<String, Integer> mapWordList) {
		List<FrequencyDTO> frequecyList = new ArrayList<FrequencyDTO>();
		mapWordList.forEach((key, value) -> frequecyList.add(new FrequencyDTO(key, value)));
		return frequecyList;	
	}

}
