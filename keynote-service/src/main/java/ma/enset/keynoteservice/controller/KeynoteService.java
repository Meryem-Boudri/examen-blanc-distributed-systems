package ma.enset.keynoteservice.controller;

import lombok.RequiredArgsConstructor;
import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.repository.KeynoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keynotes")
@RequiredArgsConstructor
public class KeynoteService {
    private final KeynoteRepository keynoteRepository;

    @GetMapping
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    @PostMapping
    public Keynote createKeynote(@RequestBody Keynote keynote) {
        return keynoteRepository.save(keynote);
    }
}
