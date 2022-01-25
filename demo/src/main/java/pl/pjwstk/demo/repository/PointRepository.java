package pl.pjwstk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.demo.model.Entity.PointEntity;

import javax.persistence.Column;
import java.util.List;


public interface PointRepository extends JpaRepository<PointEntity,Integer> {
    @Column(name = "driver_fk")
    List<PointEntity> findByDriverFk(Integer driver_fk);
}
