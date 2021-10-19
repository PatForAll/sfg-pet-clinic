package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.models.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final long ownerId = 1L;
    final String OWNER_LAST_NAME = "Smith";
    Owner returnOwner;

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(OWNER_LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerSDJpaService.findByLastName(OWNER_LAST_NAME);

        verify(ownerRepository, times(1)).findByLastName(any());
        assertEquals(ownerId, smith.getId());
        assertEquals(OWNER_LAST_NAME, smith.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnOwner);
        ownerSet.add(Owner.builder().build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> returnedOwners = ownerSDJpaService.findAll();

        verify(ownerRepository, times(1)).findAll();
        assertNotNull(ownerSet);
        assertEquals(2, returnedOwners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(ownerId);

        verify(ownerRepository, times(1)).findById(any());
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(OWNER_LAST_NAME, owner.getLastName());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.save(returnOwner);

        verify(ownerRepository, times(1)).save(any());
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(OWNER_LAST_NAME, owner.getLastName());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);

        verify(ownerRepository, times(1)).deleteById(any());
    }
}