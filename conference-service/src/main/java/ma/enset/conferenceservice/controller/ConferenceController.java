package ma.enset.conferenceservice.controller;

import lombok.RequiredArgsConstructor;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.repository.ConferenceRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceRepository conferenceRepository;



        @GetMapping
        public List<Conference> getAllConferences() {
            return conferenceRepository.findAll();
        }

        @PostMapping
        public Conference createConference(@RequestBody Conference conference) {
            return conferenceRepository.save(conference);
        }

}
