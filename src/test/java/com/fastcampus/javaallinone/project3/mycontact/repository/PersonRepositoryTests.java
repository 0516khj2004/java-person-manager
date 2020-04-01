package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName(){
        List<Person> people = personRepository.findByName("koo6");
        assertThat(people.size()).isEqualTo(1);

        Person person = people.get(0);
        assertAll(
                ()->assertThat(person.getName()).isEqualTo("koo6"),
                ()->assertThat(person.getHobby()).isEqualTo("reading"),
                ()->assertThat(person.getAddress()).isEqualTo("Seoul"),
                ()->assertThat(person.getBirthday()).isEqualTo(Birthday.of(LocalDate.of(1991,7,10))),
                ()->assertThat(person.getJob()).isEqualTo("officer"),
                ()->assertThat(person.getPhoneNumber()).isEqualTo("010-2222-5555"),
                ()->assertThat(person.isDeleted()).isEqualTo(false)
        );
    }

    @Test
    void findByNameIfDeleted(){
        List<Person> people = personRepository.findByName("koo7");
        assertThat(people.size()).isEqualTo(0);
    }

    @Test
    void findByMonthOfBirthday(){
        List<Person> people = personRepository.findByMonthOfBirthday(5);

        assertThat(people.size()).isEqualTo(2);
        assertAll(
                ()->assertThat(people.get(0).getName()).isEqualTo("koo"),
                ()->assertThat(people.get(1).getName()).isEqualTo("koo2")
        );
    }

    @Test
    void findPeopleDeleted(){
        List<Person> people = personRepository.findPeopleDeleted();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("koo7");

    }
}