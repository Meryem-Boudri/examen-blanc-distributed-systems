package ma.enset.conferenceservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service", url = "http://localhost:8083")
public interface KeynoteClient {

    @GetMapping("/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable("id") Long id);

    @GetMapping("/keynotes/")
    List<Keynote> getAllKeynotes();
}
