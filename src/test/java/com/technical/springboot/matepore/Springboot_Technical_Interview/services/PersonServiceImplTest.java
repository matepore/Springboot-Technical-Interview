package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Person;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.PersonNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.repositories.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Tag("Test of person service")
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository pRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Nested
    @Tag("Methods")
    class MethodsTests{
        @Test
        @DisplayName("test of the create function of person")
        void test_create_person() {
            //Same deal as in wallet, invocation argument gives the person object received in save to the answer.
            when(pRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

            PersonDto result = personService.create(ExampleData.PERSON_DTO001);

            assertNotNull(result);
            assertEquals(1L, result.getId());
            assertEquals("John", result.getName());
            assertEquals("Doe", result.getLastname());
            assertEquals(ExampleData.WALLET001, result.getWallet());

            verify(pRepository).save(any(Person.class));
        }

        @Test
        @DisplayName("test of the findById function of person")
        void test_find_by_id_person() {
            when(pRepository.findById(2L)).thenReturn(Optional.of(ExampleData.PERSON002));

            PersonDto result = personService.findById(2L);

            assertNotNull(result);
            assertEquals(2L, result.getId());
            assertEquals("Jane", result.getName());
            assertEquals("Doe", result.getLastname());
            assertEquals(ExampleData.WALLET002, result.getWallet());

            verify(pRepository).findById(anyLong());
        }

        @Test
        @DisplayName("test of the update function of person")
        void test_update_person() {
            when(pRepository.findById(1L)).thenReturn(Optional.of(ExampleData.PERSON001));
            when(pRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

            PersonDto updatedDto = new PersonDto(1L, "William", "Dough", ExampleData.WALLET001);
            PersonDto result = personService.update(1L, updatedDto);

            assertEquals("William", result.getName());
            assertEquals("Dough", result.getLastname());

            verify(pRepository).findById(anyLong());
            verify(pRepository).save(any());
        }

        @Test
        @DisplayName("test of the delete function of person")
        void test_delete_person() {
            when(pRepository.existsById(1L)).thenReturn(true);

            personService.delete(1L);

            verify(pRepository).existsById(anyLong());
            verify(pRepository).deleteById(anyLong());
        }

        @Test
        @DisplayName("test of the list function of person")
        void test_list_persons() {
            when(pRepository.findAll()).thenReturn(ExampleData.PERSONS);

            List<PersonDto> result = personService.list();

            assertEquals(3, result.size());
            assertEquals("John", result.get(0).getName());
            assertEquals("Jane", result.get(1).getName());
            assertEquals("James", result.get(2).getName());

            verify(pRepository).findAll();
        }
    }

    @Nested
    @Tag("Exception")
    class ExceptionTests {
        @Test
        @DisplayName("test if the PersonNotFoundException works with findById")
        void test_find_by_id_not_found_exception() {
            //Same case as the one in wallet, the empty simulates an empty value of a table.
            when(pRepository.findById(32L)).thenReturn(Optional.empty());

            assertThrows(PersonNotFoundException.class, () -> personService.findById(32L));

            verify(pRepository).findById(anyLong());
        }

        @Test
        @DisplayName("test if the PersonNotFoundException is called with update")
        void test_update_not_found_exception() {
            when(pRepository.findById(57L)).thenReturn(Optional.empty());

            PersonDto updatedDto = ExampleData.PERSON_DTO001;
            assertThrows(PersonNotFoundException.class, () -> personService.update(57L, updatedDto));

            verify(pRepository).findById(anyLong());
            //I use never here to verify that save should never be called in this case, just to be sure.
            verify(pRepository, never()).save(any(Person.class));
        }

        @Test
        @DisplayName("test if the PersonNotFoundException is called with delete")
        void test_delete_not_found_exception() {
            when(pRepository.existsById(1000L)).thenReturn(false);

            assertThrows(PersonNotFoundException.class, () -> personService.delete(1000L));

            verify(pRepository).existsById(anyLong());
            verify(pRepository, never()).delete(any());
        }
    }
}
