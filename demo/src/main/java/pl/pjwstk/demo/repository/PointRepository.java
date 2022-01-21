package pl.pjwstk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.demo.model.PointEntity;

import java.util.List;


public interface PointRepository extends JpaRepository<PointEntity,Integer> {
    List<PointEntity> findByDriverFk(Integer driverFk);
}
