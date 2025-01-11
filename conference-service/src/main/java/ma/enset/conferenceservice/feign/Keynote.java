package ma.enset.conferenceservice.feign;

import lombok.Data;

import java.util.List;
@Data
public class Keynote {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
    
}

