package ie.com.visibleThread.controllers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ie.com.visibleThread.services.DocumentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DocumentController.class)
class DocumentControllerTest {
	
	@MockBean
	DocumentService docService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void test_DocumentController_getWordsFrequency_success() throws Exception {
	 
	    when(docService.getTop10FrequentWords(anyString())).thenCallRealMethod();
	 
	    mockMvc.perform(get("/document/getWordFrequency").param("document", "Test test test testing"))	
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(2)))
	        .andExpect(jsonPath("$[0].word", Matchers.is("test")))
	        .andExpect(jsonPath("$[0].frequency", Matchers.is(3)))
	        .andExpect(jsonPath("$[1].word", Matchers.is("testing")))
	        .andExpect(jsonPath("$[1].frequency", Matchers.is(1)));
	    
	    verify(docService, times(1)).getTop10FrequentWords(anyString());
		
	}
	
	@Test
	void test_DocumentController_getWordsFrequency_fail_if_parameter_is_blank() throws Exception {
		
		when(docService.getTop10FrequentWords(anyString())).thenCallRealMethod();
		
		mockMvc.perform(get("/document/getWordFrequency").param("document", " "))	
        .andExpect(status().isUnprocessableEntity());
		
		 verify(docService, times(1)).getTop10FrequentWords(anyString());
		
	}
	
	@Test
	void test_DocumentController_getWordsFrequency_fail_if_parameter_is_empty() throws Exception {
		
		when(docService.getTop10FrequentWords(anyString())).thenCallRealMethod();
		
		mockMvc.perform(get("/document/getWordFrequency").param("document", ""))	
        .andExpect(status().isUnprocessableEntity());
		
		 verify(docService, times(1)).getTop10FrequentWords(anyString());
		
	}	
	
	
	@Test
	void test_DocumentController_getWordsFrequency_fail_if_parameter_is_not_present() throws Exception {
		
		mockMvc.perform(get("/document/getWordFrequency"))	
        .andExpect(status().isBadRequest());
		
		 verify(docService, times(0)).getTop10FrequentWords(anyString());
		
	}
	

}
