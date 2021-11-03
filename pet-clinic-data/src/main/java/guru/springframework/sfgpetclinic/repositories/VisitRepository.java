package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    Set<Visit> findByPetId(Long petId);
}
