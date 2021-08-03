package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
