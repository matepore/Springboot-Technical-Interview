package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.BilleteraDto;

import java.util.List;

public interface BilleteraService {
    BilleteraDto create(BilleteraDto bdto);
    BilleteraDto findById(Long id);
    BilleteraDto update(Long id, BilleteraDto bdto);
    void delete (Long id);
    List<BilleteraDto> list();
}
