package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.client.TelefonoApiClient;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Person;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.PersonNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository pRepository;
    private final TelefonoApiClient telefonoClient;


    private PersonDto mapDto(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .lastname(person.getLastname())
                .wallet(person.getWallet())
                .build();
    }

    private Person mapEntity(PersonDto pDto){
        return Person.builder()
                .id(pDto.getId())
                .name(pDto.getName())
                .lastname(pDto.getLastname())
                .wallet(pDto.getWallet())
                .build();
    }

    @Override
    public PersonDto create(PersonDto pdto) {
        log.info("Adding a new person to the database.");
        Person person = pRepository.save(mapEntity(pdto));
        return mapDto(person);
    }

    @Override
    @Cacheable("persons")
    public PersonDto findById(Long id) {
        log.info("Trying to find a person by the id: {}", id);
        return pRepository.findById(id)
                .map(person -> this.mapDto(person))
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public PersonDto update(Long id, PersonDto pdto) {
        log.info("Updating the person with the id: {}", id);
        Person person = pRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        person.setName(pdto.getName());
        person.setLastname(pdto.getLastname());
        person.setWallet(pdto.getWallet());
        return mapDto(pRepository.save(person));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting the person with the id: {}", id);
        if(!pRepository.existsById(id)){
            throw new PersonNotFoundException(id);
        }
        pRepository.deleteById(id);
    }

    @Override
    public List<PersonDto> list() {
        log.info(telefonoClient.getNumero().getNumero() + " This is a phone number.");
        log.info("Showing a list of all persons.");
        return pRepository.findAll().stream().map(person -> this.mapDto(person)).toList();
    }
}