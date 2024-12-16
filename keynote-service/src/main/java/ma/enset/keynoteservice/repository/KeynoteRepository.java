package ma.enset.keynoteservice.repository;

import ma.enset.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}
