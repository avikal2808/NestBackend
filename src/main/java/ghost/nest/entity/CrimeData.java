package ghost.nest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "crime_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String crimeType;

    @Column(nullable = false)
    private Integer severity;  // 1-10 scale

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
