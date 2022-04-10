package ie.com.visibleThread.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.com.visibleThread.dtos.UserDTO;
import ie.com.visibleThread.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUsersWithoutUpload")
	public List<UserDTO> getUsersWithoutUpload(
			@RequestParam(value = "dateStart", required = true) String dateStart,
			@RequestParam(value = "dateEnd", required = true) String dateEnd) {

		return userService.getUserWithoutUpload(dateStart, dateEnd);
	
	}

}
