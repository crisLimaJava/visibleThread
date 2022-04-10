package ie.com.visibleThread.repositories;

import static ie.com.visibleThread.util.DateParse.toLocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ie.com.visibleThread.entities.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;
		
	@Test
	void test_findUserWithNoUpload_found_users_success() {
		List<User> usersList = userRepo.findUserWithNoUpload(toLocalDateTime("01-04-2022 00:00:00"), toLocalDateTime("01-05-2022 00:00:00"));
		assertNotNull(usersList);
		assertEquals(2, usersList.size());
	}
	
	@Test
	void test_findUserWithNoUpload_any_user_found_success() {
		List<User> usersList = userRepo.findUserWithNoUpload(toLocalDateTime("01-02-2022 00:00:00"), toLocalDateTime("01-03-2022 00:00:00"));
		assertNotNull(usersList);
		assertEquals(0, usersList.size());
	}

}
