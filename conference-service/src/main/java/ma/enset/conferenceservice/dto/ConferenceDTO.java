package ma.enset.conferenceservice.dto;


import lombok.Data;

import java.util.List;
@Data
public class ConferenceDTO {
    private Long id;
    private String title;
    private String type;
    private String date;
    private Integer durationInMinutes;
    private Integer numberOfRegistrants;
    private Integer score;
    private List<ReviewDTO> reviews;

    // Getters and Setters
}
