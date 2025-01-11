package ma.enset.conferenceservice.controller;

import lombok.AllArgsConstructor;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.entities.Review;
import ma.enset.conferenceservice.feign.Keynote;
import ma.enset.conferenceservice.feign.KeynoteClient;
import ma.enset.conferenceservice.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/conferences")
public class ConferenceController {

    private ConferenceService conferenceService;
    private KeynoteClient keynoteClient;

    // Créer une conférence
    @PostMapping("/create")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceService.createConference(conference));
    }

    // Récupérer toutes les conférences
    @GetMapping("/all")
    public ResponseEntity<List<Conference>> getAllConferences() {
        return ResponseEntity.ok(conferenceService.getAllConferences());
    }

    // Récupérer une conférence par ID
    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.getConferenceById(id));
    }

    // Ajouter une review à une conférence
    @PostMapping("/{conferenceId}/reviews")
    public ResponseEntity<Review> addReviewToConference(@PathVariable Long conferenceId, @RequestBody Review review) {
        return ResponseEntity.ok(conferenceService.addReviewToConference(conferenceId, review));
    }

    @GetMapping("/keynote/{id}")
    public ResponseEntity<Keynote> getKeynoteById(@PathVariable Long id) {
        return ResponseEntity.ok(keynoteClient.getKeynoteById(id));
    }

}
