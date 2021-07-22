package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Owner extends Person {

    private Set<Pet> petList;

    public Set<Pet> getPetList() {
        return petList;
    }

    public void setPetList(Set<Pet> petList) {
        this.petList = petList;
    }
}
