package pl.pjwstk.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pjwstk.demo.model.DriversEntity;


public interface DriversRepository extends CrudRepository<DriversEntity,Integer> {
}
