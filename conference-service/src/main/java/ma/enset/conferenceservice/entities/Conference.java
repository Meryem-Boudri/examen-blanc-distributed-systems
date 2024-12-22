package ma.enset.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.conferenceservice.feign.Keynote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type; // Academic or Commercial
    private LocalDate date;
    private int duration;
    private int attendees;
    private double score;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
    private List<Review> reviews = new ArrayList<>();
    private Long keynoteId;
}

