package ma.enset.conferenceservice;

import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.repository.ConferenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients

public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository){
        return args ->{
            conferenceRepository.save(Conference.builder().id(11L).score(3).title("con1").date(LocalDate.now()).keynoteId(3L).duration(40).build());
            conferenceRepository.save(Conference.builder().id(12L).score(1).title("con2").date(LocalDate.now()).keynoteId(2L).duration(40).build());
            conferenceRepository.save(Conference.builder().id(13L).score(2).title("con3").date(LocalDate.now()).keynoteId(3L).duration(40).build());
        };
    }
}
