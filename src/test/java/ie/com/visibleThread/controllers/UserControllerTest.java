package ie.com.visibleThread.controllers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ie.com.visibleThread.dtos.UserDTO;
import ie.com.visibleThread.entities.User;
import ie.com.visibleThread.services.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

	@MockBean
	UserService userService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void test_getUsersWithoutUpload_success() throws Exception {
		
		User u1 = new User();
		u1.setId(99);

		when(userService.getUserWithoutUpload(anyString(), anyString())).thenReturn(Arrays.asList(new UserDTO(u1)));

		mockMvc.perform(get("/user/getUsersWithoutUpload")
				.param("dateStart", "01-04-2022 00:00:00")
				.param("dateEnd", "01-05-2022 00:00:00"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
		
		verify(userService, times(1)).getUserWithoutUpload(anyString(), anyString());
	}
	
	@Test
	void test_getUsersWithoutUpload_fail_if_date_format_is_wrong() throws Exception {

		when(userService.getUserWithoutUpload(anyString(), anyString())).thenCallRealMethod();

		mockMvc.perform(get("/user/getUsersWithoutUpload")
				.param("dateStart", "2022-04-01 00:00:00")
				.param("dateEnd", "2022-05-20 00:00:00"))
		.andExpect(status().isPreconditionFailed());
		
		verify(userService, times(1)).getUserWithoutUpload(anyString(), anyString());
	}

}
