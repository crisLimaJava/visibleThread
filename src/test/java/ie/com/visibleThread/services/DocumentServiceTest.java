package ie.com.visibleThread.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ie.com.visibleThread.dtos.FrequencyDTO;
import ie.com.visibleThread.exceptions.TextNotPresentException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DocumentServiceTest {

	private static final String TEXT_TO_TEST = "The Testing Testing Testing how how many words there are on this text text text text text";

	@Autowired
	private DocumentService service;

	@Test
	void test_getTop10FrequentWords_success() {

		List<FrequencyDTO> top10List = service.getTop10FrequentWords(TEXT_TO_TEST);

		assertNotNull(top10List);
		assertTrue(top10List.get(0).getWord().equals("text"));
		assertEquals(5, top10List.get(0).getFrequency());
		assertEquals(9, top10List.size());

	}

	@Test
	void test_getTop10FrequentWords_fail_for_text_null_get_TextNotPresentException() {

		TextNotPresentException exception = assertThrows(TextNotPresentException.class,
				() -> service.getTop10FrequentWords(null));

		assertNotNull(exception);
		assertEquals("Text not present", exception.getMessage());
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatus());

	}

	@Test
	void test_getTop10FrequentWords_fail_for_text_empty_get_TextNotPresentException() {

		String strEmpty = "";

		TextNotPresentException exception = assertThrows(TextNotPresentException.class,
				() -> service.getTop10FrequentWords(strEmpty));

		assertNotNull(exception);
		assertEquals("Text not present", exception.getMessage());
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatus());

	}

	@Test
	void test_getTop10FrequentWords_fail_for_text_blank_get_TextNotPresentException() {

		String strBlank = " ";

		TextNotPresentException exception = assertThrows(TextNotPresentException.class,
				() -> service.getTop10FrequentWords(strBlank));

		assertNotNull(exception);
		assertEquals("Text not present", exception.getMessage());
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatus());

	}

}
