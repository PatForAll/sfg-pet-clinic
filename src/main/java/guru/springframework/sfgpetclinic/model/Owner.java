package guru.springframework.sfgpetclinic.model;

import java.util.List;

public class Owner extends Person {

    List<Pet> petList;

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
