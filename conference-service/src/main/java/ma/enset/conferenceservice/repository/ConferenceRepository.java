package ma.enset.conferenceservice.repository;

import ma.enset.conferenceservice.entities.Conference;
import ma.enset.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
