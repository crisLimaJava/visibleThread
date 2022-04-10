package ie.com.visibleThread.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import ie.com.visibleThread.entities.Team;
import ie.com.visibleThread.entities.User;
import lombok.Data;

@Data
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String email;
	
	private LocalDateTime dateCreation;
	
	private List<Team> teams;
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.dateCreation = entity.getDateCreation();
		this.teams = entity.getTeams();
	}
	

}
