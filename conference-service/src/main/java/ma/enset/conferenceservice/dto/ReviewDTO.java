package ma.enset.conferenceservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private Long id;
    private String reviewerName;
    private String reviewText;
    private Integer stars;
    private LocalDateTime dateReviewed;

}

