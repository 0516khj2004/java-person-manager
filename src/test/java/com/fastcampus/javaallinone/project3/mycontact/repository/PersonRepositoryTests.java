package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("Koo");
        person.setAge(25);
        person.setBloodType("A");
        personRepository.save(person);
        System.out.println(personRepository.findAll());

        List<Person> peoples = personRepository.findAll();

        assertThat(peoples.size()).isEqualTo(1);
        assertThat(peoples.get(0).getName()).isEqualTo("Koo");
        assertThat(peoples.get(0).getAge()).isEqualTo(25);
        assertThat(peoples.get(0).getBloodType()).isEqualTo("A");
    }
//    @Test
//    void  constructorTest(){
//        Person person = new Person("Koo",10);
//
//    }

    @Test
    void hashcodeEquals(){
        Person person1 = new Person("Koo", 25,"A");
        Person person2 = new Person("Koo", 25,"A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));

    }

}