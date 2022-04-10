package ie.com.visibleThread.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import ie.com.visibleThread.exceptions.DateParseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateParse {
	
	private static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
	
	/**
	 * Method to parse String to LocalDateTime 
	 * 
	 * If date string format different than 'dd-MM-yyyy HH:mm:ss' throws DateParseException;
	 * 
	 * @param strDate
	 * @return LocalDateTime
	 * @exception DateParseException
	 */
	public static LocalDateTime toLocalDateTime(String strDate) {		
		try {
			
			return LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(DATE_PATTERN));
		
		}catch(DateTimeParseException e) {
			log.error(e.getMessage());
			throw new DateParseException(String.format("Wrong date format received: %s, FORMAT EXPECTED: %s", strDate, DATE_PATTERN));
		}catch (Exception e) {
			log.error(e.getMessage());
			throw new DateParseException(String.format("Error to parse date: %s", strDate));
		}
	}

}
