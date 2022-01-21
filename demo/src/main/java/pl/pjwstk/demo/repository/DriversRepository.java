package pl.pjwstk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.demo.model.DriversEntity;


public interface DriversRepository extends JpaRepository<DriversEntity,Integer> {
}
