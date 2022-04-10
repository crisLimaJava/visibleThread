package ie.com.visibleThread.components.interfaces;

import java.util.List;

import ie.com.visibleThread.dtos.UserDTO;

public interface IUserService {
	
	public List<UserDTO> getUserWithoutUpload(String dateStart, String dateEnd);

}
