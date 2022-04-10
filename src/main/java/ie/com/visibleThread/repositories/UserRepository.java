package ie.com.visibleThread.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ie.com.visibleThread.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.dateCreation < ?2 and u.id not in (select d.user from Document d where d.uploadDate between ?1 and ?2)")
	public List<User> findUserWithNoUpload(LocalDateTime start, LocalDateTime end);
	

}
