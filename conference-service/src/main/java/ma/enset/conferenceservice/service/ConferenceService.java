package ma.enset.conferenceservice.service;

import lombok.AllArgsConstructor;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.entities.Review;
import ma.enset.conferenceservice.feign.Keynote;
import ma.enset.conferenceservice.feign.KeynoteClient;
import ma.enset.conferenceservice.repository.ConferenceRepository;
import ma.enset.conferenceservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final ReviewRepository reviewRepository;
    private final KeynoteClient keynoteRestClient;

    public Conference createConference(Conference conference) {
        // Vérifier si le conférencier (Keynote) existe
        Keynote keynote = keynoteRestClient.getKeynoteById(conference.getKeynoteId());
        if (keynote == null) {
            throw new RuntimeException("Keynote not found!");
        }
        conference.setKeynoteId(keynote.getId()); // Associer le conférencier à la conférence
        return conferenceRepository.save(conference);
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id).orElse(null);
    }

    public Review addReviewToConference(Long conferenceId, Review review) {
        Conference conference = conferenceRepository.findById(conferenceId).orElse(null);
        if (conference == null) {
            throw new RuntimeException("Conference not found!");
        }
        review.setConference(conference);
        return reviewRepository.save(review);
    }
}
