package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.models.Visit;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long> {
    Set<Visit> findByPetId(Long petId);
}
