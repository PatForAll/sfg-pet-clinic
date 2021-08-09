package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) loadData();
    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");

        PetType savedPetType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType1.setName("Cat");

        PetType savedPetType2 = petTypeService.save(petType2);

        System.out.println("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerstreet");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetType1);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Doggo");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Johnson");
        owner1.setAddress("123 Brickerstreet");
        owner1.setCity("Miami");
        owner1.setTelephone("987654321");

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetType2);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Kitty");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners & Pets...");

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Basic Checkup");

        visitService.save(visit1);

        Visit visit2 = new Visit();
        visit2.setPet(pet2);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Castration");

        visitService.save(visit2);

        System.out.println("Loaded Visits...");


        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Dog Expert");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(speciality1);

        vetService.save(vet1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Cat Expert");

        Vet vet2 = new Vet();
        vet2.setFirstName("Anna");
        vet2.setLastName("Harte");
        vet2.getSpecialities().add(speciality2);

        vetService.save(vet2);

        System.out.println("Loaded Vets & Specialities...");
    }
}
