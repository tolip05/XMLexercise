package cardiller.domein.enteties.repositoris;

import cardiller.domein.enteties.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {

}
