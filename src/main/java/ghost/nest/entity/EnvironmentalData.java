package ghost.nest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "environmental_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnvironmentalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double airQualityIndex;  // lower is better (0-500)

    @Column(nullable = false)
    private Double waterReliabilityScore;  // 0-1

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
