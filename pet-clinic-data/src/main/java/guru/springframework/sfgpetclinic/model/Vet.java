package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    private Set<Speciality> specialties;
}
