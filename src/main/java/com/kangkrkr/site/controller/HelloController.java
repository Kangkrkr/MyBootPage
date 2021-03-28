package com.kangkrkr.site.controller;

import com.kangkrkr.site.dao.jpa.PersonJpaDao;
import com.kangkrkr.site.dao.mybatis.PersonDao;
import com.kangkrkr.site.domain.Person;
import com.kangkrkr.site.service.PersonQdslService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    private PersonDao personDao1;
    private PersonJpaDao testDao2;
    private PersonQdslService personQdslService;

    @RequestMapping("/test")
    public String hello() {
        return "Say Hello!";
    }

    @RequestMapping("/mybatis/persons")
    public List<Person> getPersonsByMybatis() {
        return personDao1.getPerson();
    }

    @RequestMapping("/jpa/persons")
    public List<com.kangkrkr.site.entity.Person> getPersonsByJpa() {
        return testDao2.findAll();
    }

    @RequestMapping("/querydsl/persons")
    public List<com.kangkrkr.site.entity.Person> getPersonsByQueyDSL() {
        return personQdslService.getPersons();
    }

    @RequestMapping("/save")
    public com.kangkrkr.site.entity.Person savePerson() {
        return personQdslService.savePerson();
    }
}
