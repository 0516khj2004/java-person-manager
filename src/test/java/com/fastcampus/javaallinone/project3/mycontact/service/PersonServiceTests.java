package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTests {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void getPeopleByName() {
        when(personRepository.findByName("koo"))
                .thenReturn(Lists.newArrayList(new Person("koo")));

        List<Person> result = personService.getPeopleByName("koo");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("koo");
    }

    @Test
    void getPerson() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("koo")));

        Person person = personService.getPerson(1L);

        assertThat(person.getName()).isEqualTo("koo");
    }

    @Test
    void getPersonIfNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        Person person = personService.getPerson(1L);

        assertThat(person).isNull();
    }

    @Test
    void put() {
        personService.put(mockPersonDto());

        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeInserted()));
    }

    private PersonDto mockPersonDto() {
        return PersonDto.of("koo", "programing",
                "판교", LocalDate.now(), "programmer", "010-9623-0516");
    }

    @Test
    void modifyPersonNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> personService.modify(1L, mockPersonDto()));
    }

    @Test
    void modifyNameIsDifferent() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("koo1")));
        assertThrows(RuntimeException.class, () -> personService.modify(1L, mockPersonDto()));
    }

    @Test
    void modify() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("koo")));

        personService.modify(1L, mockPersonDto());
//        verify(personRepository, times(1)).save(any(Person.class));
        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeUpdated()));
    }

    @Test
    void modifyNameIfPersonNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.modify(1L, "denial"));
    }

    @Test
    void modifyByName() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("koo")));

        personService.modify(1L, "denial");
        verify(personRepository, times(1)).save(argThat(new IsNameWillBeUpdated()));
    }

    @Test
    void deleteIfPersonNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.delete(1L));
    }

    @Test
    void delete() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("martin")));

        personService.delete(1L);

        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeDeleted()));
    }



    private static class IsPersonWillBeInserted implements ArgumentMatcher<Person> {

        @Override
        public boolean matches(Person person) {
            return equals(person.getName(), "koo") &&
                    equals(person.getHobby(), "programing") &&
                    equals(person.getAddress(), "판교") &&
                    equals(person.getBirthday(), Birthday.of(LocalDate.now())) &&
                    equals(person.getJob(), "programmer") &&
                    equals(person.getPhoneNumber(), "010-9623-0516");

        }

        private boolean equals(Object actual, Object expected) {
            return expected.equals(actual);
        }
    }

    private static class IsPersonWillBeUpdated implements ArgumentMatcher<Person> {

        @Override
        public boolean matches(Person person) {
            return equals(person.getName(), "koo") &&
                    equals(person.getHobby(), "programing") &&
                    equals(person.getAddress(), "판교") &&
                    equals(person.getBirthday(), Birthday.of(LocalDate.now())) &&
                    equals(person.getJob(), "programmer") &&
                    equals(person.getPhoneNumber(), "010-9623-0516");

        }

        private boolean equals(Object actual, Object expected) {
            return expected.equals(actual);
        }
    }

    private static class IsNameWillBeUpdated implements ArgumentMatcher<Person> {
        @Override
        public boolean matches(Person person) {
            return person.getName().equals("denial");
        }
    }

    private static class IsPersonWillBeDeleted implements ArgumentMatcher<Person> {
        @Override
        public boolean matches(Person person) {
            return person.isDeleted();
        }
    }
}