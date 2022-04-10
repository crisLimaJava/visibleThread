package ie.com.visibleThread.services;

import static ie.com.visibleThread.util.DateParse.toLocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.com.visibleThread.components.interfaces.IUserService;
import ie.com.visibleThread.dtos.UserDTO;
import ie.com.visibleThread.entities.User;
import ie.com.visibleThread.repositories.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository repo;

	/**
	 * Method to retrive all users registred that didn't any upload in the date range informed
	 * 
	 * @param String strDateStart
	 * @param String strDateEnd
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getUserWithoutUpload(String strDateStart, String strDateEnd) {
		
		List<User> userList = repo.findUserWithNoUpload(toLocalDateTime(strDateStart), toLocalDateTime(strDateEnd));
		
		return userList.stream().map((user) -> new UserDTO(user)).collect(Collectors.toList());
	}
	
}
