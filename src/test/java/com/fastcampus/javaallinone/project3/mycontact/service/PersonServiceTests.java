package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@SpringBootTest
class PersonServiceTests {
    @Autowired
    private PersonService personService;

    @Test
    void getPeopleExcludeBlocks(){
        List<Person> result = personService.getPeopleExcludeBlocks();

        result.forEach(System.out::println);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getName()).isEqualTo("koo2");
        assertThat(result.get(1).getName()).isEqualTo("koo3");
        assertThat(result.get(2).getName()).isEqualTo("koo4");
    }
    @Test
    void getPeopleByName(){

        List<Person> result = personService.getPeopleByName("koo");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("koo");
    }

    @Test
    void getPerson(){
        Person person  = personService.getPerson(4L);

        assertThat(person.getName()).isEqualTo("koo3");
    }

}