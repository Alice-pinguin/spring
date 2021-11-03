package ua.goit.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.homework.entity.Manufacturer;
import ua.goit.homework.service.ManufacturerService;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/manufacturer")
public class ManufacturerController {

    private final ManufacturerService service;

    @GetMapping(path = "/findAllManufacturers")
    public ModelAndView showAllManufacturersPage(ModelAndView model) {
        Iterable<Manufacturer> manufacturers = service.findAll();
        model.addObject("manufacturers", manufacturers);
        model.setViewName("findAllManufacturers");
        return model;
    }

    @GetMapping(path = "/findManufacturerById")
    public ModelAndView showManufacturerById(@RequestParam(name = "id") Long id, ModelAndView model) {
        Optional<Manufacturer> manufacturer = service.findById(id);
        model.addObject("manufacturer", manufacturer.get());
        model.setViewName("findManufacturerById");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/update")
    public String showUpdateManufacturerPage(@RequestParam(name = "id") Long id, Model model) {
        Optional<Manufacturer> manufacturer = service.findById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "updateManufacturerForm";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/updateManufacturer")
    public RedirectView updateManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        service.save(manufacturer);
        return new RedirectView("/manufacturer/findAllManufacturers");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/add")
    public String showAddFormManufacturerPage(Model model) {
        return "addManufacturerForm";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/addManufacturer")
    public RedirectView addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        service.save(manufacturer);
        return new RedirectView("/manufacturers/findAllManufacturers");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam("id") Long id) {
        service.deleteById(id);
        return new RedirectView("/manufacturers/findAllManufacturers");
    }

    @ModelAttribute(name = "manufacturer")
    public Manufacturer defaultManufacturer() {
        return new Manufacturer();
    }
}
