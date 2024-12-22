package ma.enset.conferenceservice.feign;

import lombok.Data;

import java.util.List;
@Data
public class Keynote {

    private Long id;
    private String title;
    private String speaker;
    private String description;
    private String date;

    
}

