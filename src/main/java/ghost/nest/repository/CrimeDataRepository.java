package ghost.nest.repository;

import ghost.nest.entity.CrimeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeDataRepository extends JpaRepository<CrimeData, Long> {

    @Query("SELECT c FROM CrimeData c WHERE " +
            "c.latitude BETWEEN :lat - (:radius / 111000.0) AND :lat + (:radius / 111000.0) AND " +
            "c.longitude BETWEEN :lng - (:radius / (111000.0 * 0.75)) AND :lng + (:radius / (111000.0 * 0.75)) AND " +
            "c.timestamp >= :since")
    List<CrimeData> findRecentWithinRadius(@Param("lat") Double lat,
                                           @Param("lng") Double lng,
                                           @Param("radius") Double radiusMeters,
                                           @Param("since") java.time.LocalDateTime since);
}
