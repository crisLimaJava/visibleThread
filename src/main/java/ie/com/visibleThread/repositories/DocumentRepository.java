package ie.com.visibleThread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.com.visibleThread.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{


}
