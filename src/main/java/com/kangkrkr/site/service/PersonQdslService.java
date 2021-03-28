package com.kangkrkr.site.service;

import com.kangkrkr.site.dao.jpa.PersonJpaDao;
import com.kangkrkr.site.dao.querydsl.PersonQdslDao;
import com.kangkrkr.site.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class PersonQdslService {

    @Autowired
    private PersonJpaDao personJpaDao;

    @Autowired
    private PersonQdslDao personQdslDao;

    @Transactional(readOnly = true)
    public List<Person> getPersons() {
        return personQdslDao.getPersons();
    }

    @Transactional(rollbackFor = Exception.class)
    public Person savePerson() {
        int rand = new Random().nextInt(100);

        Person person = new Person();
        person.setName("강승윤#" + rand);
        person.setEmail("kangkrkr" + rand + "@naver.com");
        person.setPasswd("1234567890" + rand);

        return personJpaDao.saveAndFlush(person);
    }
}