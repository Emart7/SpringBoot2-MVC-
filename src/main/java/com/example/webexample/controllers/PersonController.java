package com.example.webexample.controllers;

import com.example.webexample.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private static List<Person> persons = new ArrayList<>();

    public PersonController() {
        persons.add(new Person("123456789", "CC", "Juan", "Perez", "123456789"));
        persons.add(new Person("987456321", "CC", "Andrea", "Mata", "987456321"));
        persons.add(new Person("147852369", "CC", "Jorge", "Saenz", "147852369"));
        persons.add(new Person("369852147", "CE", "Robert", "Casas", "369852147"));
    }


    //Method to get all records - Long method
//    @GetMapping("/persons")
//    public List<Person> searchPersons(@RequestParam("identification") String identification,
//                                      @RequestParam(value = "identificationType", required = false) String identificationType,
//                                      @RequestParam(value = "name", required = false) String name,
//                                      @RequestParam(value = "lastName", required = false) String lastName,
//                                      @RequestParam(value = "phone", required = false) String phone) {
//
//        return persons.stream()
//                .filter(p -> identification == null || identification.equals(p.getIdentification()))
//                .filter(p -> identificationType == null || identificationType.equals(p.getIdentificationType()))
//                .filter(p -> name == null || name.equals(p.getName()))
//                .filter(p -> lastName == null || lastName.equals(p.getLastName()))
//                .filter(p -> phone == null || phone.equals(p.getPhone()))
//                .collect(Collectors.toList());
//    }

    //Method to get all records - Short method
    @GetMapping("/persons")
    public List<Person> searchPersons(@RequestParam Map<String, String> parameters) {

        return persons.stream()
                .filter(p -> parameters.get("identification") == null || parameters.get("identification").equals(p.getIdentification()))
                .filter(p -> parameters.get("identificationType") == null || parameters.get("identificationType").equals(p.getIdentificationType()))
                .filter(p -> parameters.get("name") == null || parameters.get("name").equals(p.getName()))
                .filter(p -> parameters.get("lastName") == null || parameters.get("lastName").equals(p.getLastName()))
                .filter(p -> parameters.get("phone") == null || parameters.get("phone").equals(p.getPhone()))
                .collect(Collectors.toList());
    }

}
