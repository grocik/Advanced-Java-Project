package pl.pjwstk.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pjwstk.demo.model.PointEntity;

public interface PointRepository extends CrudRepository<PointEntity,Integer> {
}
