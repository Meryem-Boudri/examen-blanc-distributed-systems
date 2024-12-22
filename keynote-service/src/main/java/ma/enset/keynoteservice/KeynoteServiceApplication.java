package ma.enset.keynoteservice;

import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.repository.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository){
        return args ->{
            keynoteRepository.save(Keynote.builder().id(1111L).firstName("C0").email("@gmail.com").build());
            keynoteRepository.save(Keynote.builder().id(1112L).firstName("C1").email("@gmail.com").build());
            keynoteRepository.save(Keynote.builder().id(1113L).firstName("C2").email("@gmail.com").build());
        };
    }

}
