package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.mvc;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonControllerMvc {

    private final PersonService personService;

    // LIST
    @GetMapping
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.list());
        return "persons/list"; // Renders list.html
    }

    // SHOW CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("person", new PersonDto());
        return "persons/form"; // form.html
    }

    // CREATE
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") PersonDto personDto,
                             RedirectAttributes redirectAttributes) {
        personService.create(personDto);
        redirectAttributes.addFlashAttribute("success", "Person created successfully!");
        return "redirect:/persons";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        PersonDto personDto = personService.findById(id);
        model.addAttribute("person", personDto);
        return "persons/form"; // Same view as create
    }

    // UPDATE
    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id,
                               @ModelAttribute("person") PersonDto personDto,
                               RedirectAttributes redirectAttributes) {
        personService.update(id, personDto);
        redirectAttributes.addFlashAttribute("success", "Person updated successfully!");
        return "redirect:/persons";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id,
                               RedirectAttributes redirectAttributes) {
        personService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Person deleted successfully!");
        return "redirect:/persons";
    }
}
