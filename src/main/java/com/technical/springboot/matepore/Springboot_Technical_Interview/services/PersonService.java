package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto create(PersonDto pdto);
    PersonDto findById(Long id);
    PersonDto update(Long id, PersonDto pdto);
    void delete(Long id);
    List<PersonDto> list();
}
