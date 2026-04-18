package ghost.nest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "infrastructure_projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfrastructureProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private LocalDate expectedCompletionDate;

    @Column(nullable = false)
    private Double impactScore;  // 0-1
}
