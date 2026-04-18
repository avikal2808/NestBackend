package ghost.nest.repository;

import ghost.nest.entity.InfrastructureProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfrastructureProjectRepository extends JpaRepository<InfrastructureProject, Long> {

    @Query("SELECT i FROM InfrastructureProject i WHERE " +
            "i.latitude BETWEEN :lat - (:radius / 111000.0) AND :lat + (:radius / 111000.0) AND " +
            "i.longitude BETWEEN :lng - (:radius / (111000.0 * 0.75)) AND :lng + (:radius / (111000.0 * 0.75))")
    List<InfrastructureProject> findWithinRadius(@Param("lat") Double lat,
                                                 @Param("lng") Double lng,
                                                 @Param("radius") Double radiusMeters);
}
