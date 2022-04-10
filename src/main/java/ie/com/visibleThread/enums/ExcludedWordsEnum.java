package ie.com.visibleThread.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ExcludedWordsEnum {
	
	THE("the"), 
	ME("me"), 
	YOU("you"), 
	I("i"),
	OF("of"), 
	AND("and"), 
	A("a"), 
	WE("we");
	
	
	private String value;

	private ExcludedWordsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	public static List<String> getValues(){
		return Arrays.asList(ExcludedWordsEnum.values())
				.stream().map(e -> e.getValue()).collect(Collectors.toList());
	}

}
