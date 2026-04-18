package ghost.nest.repository;

import ghost.nest.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE " +
            "p.latitude BETWEEN :lat - (:radius / 111000.0) AND :lat + (:radius / 111000.0) AND " +
            "p.longitude BETWEEN :lng - (:radius / (111000.0 * 0.75)) AND :lng + (:radius / (111000.0 * 0.75))")
    List<Property> findPropertiesWithinRadius(@Param("lat") Double lat,
                                              @Param("lng") Double lng,
                                              @Param("radius") Double radiusMeters);
}
