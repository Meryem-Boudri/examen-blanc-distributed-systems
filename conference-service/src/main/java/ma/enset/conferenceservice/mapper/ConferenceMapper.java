package ma.enset.conferenceservice.mapper;


import ma.enset.conferenceservice.dto.ConferenceDTO;
import ma.enset.conferenceservice.dto.ReviewDTO;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.entities.Review;

import java.util.List;

public interface ConferenceMapper {

    ConferenceDTO toDto(Conference conference);

    List<ConferenceDTO> toDtoList(List<Conference> conferences);

    ReviewDTO toDto(Review review);

    List<ReviewDTO> toDto(List<Review> reviews);
}
