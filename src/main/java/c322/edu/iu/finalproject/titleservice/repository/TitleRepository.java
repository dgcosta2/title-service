package c322.edu.iu.finalproject.titleservice.repository;

import c322.edu.iu.finalproject.titleservice.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {

    public List<Title> findByMemberId(int memberId);
}
