package cardiller.domein.enteties.repositoris;

import cardiller.domein.enteties.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
