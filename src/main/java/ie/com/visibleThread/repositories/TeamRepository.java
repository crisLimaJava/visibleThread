package ie.com.visibleThread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.com.visibleThread.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	public Team findByName(String name);

}
