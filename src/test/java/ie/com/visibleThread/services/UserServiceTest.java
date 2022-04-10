package ie.com.visibleThread.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ie.com.visibleThread.exceptions.DateParseException;
import ie.com.visibleThread.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {
	
	@MockBean
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;

	@Test
	void test_getUserWithoutUpload_success() {		
		userService.getUserWithoutUpload("01-01-2022 00:00:00", "30-01-2022 00:00:00");		
		verify(userRepo, times(1)).findUserWithNoUpload(any(LocalDateTime.class), any(LocalDateTime.class));		
	}
	
	@Test
	void test_getUserWithoutUpload_wrong_format_date_fail() {	
		
		DateParseException exception = assertThrows(DateParseException.class, 
		 () -> userService.getUserWithoutUpload("2022-01-01 00:00:00", "30-01-2022 00:00:00"));		
		
		verify(userRepo, times(0)).findUserWithNoUpload(any(LocalDateTime.class), any(LocalDateTime.class));		
		assertEquals(HttpStatus.PRECONDITION_FAILED, exception.getStatus());
		assertEquals("Wrong date format received: 2022-01-01 00:00:00, FORMAT EXPECTED: dd-MM-yyyy HH:mm:ss", exception.getMessage());
		
	}
	

}
