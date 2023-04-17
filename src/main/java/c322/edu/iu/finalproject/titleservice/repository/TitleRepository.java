package c322.edu.iu.finalproject.titleservice.repository;

import c322.edu.iu.finalproject.titleservice.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {

}
