package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
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
    void crud(){
        Person person = new Person();
        person.setName("john");
        person.setAge(25);
        person.setBloodType("A");
        personRepository.save(person);

        List<Person> result = personRepository.findByName("john");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("john");
        assertThat(result.get(0).getAge()).isEqualTo(25);
        assertThat(result.get(0).getBloodType()).isEqualTo("A");


    }
//    @Test
//    void  constructorTest(){
//        Person person = new Person("Koo",10);
//
//    }

    @Test
    void findByBloodType() {
        List<Person> result = personRepository.findByBloodType("A");
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("koo");
        assertThat(result.get(1).getName()).isEqualTo("koo4");

    }

    @Test
    void findByBirthdayBetween(){
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("koo");
        assertThat(result.get(1).getName()).isEqualTo("koo1");

    }

}