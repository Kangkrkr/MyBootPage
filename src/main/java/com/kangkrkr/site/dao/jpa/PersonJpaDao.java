package com.kangkrkr.site.dao.jpa;

import com.kangkrkr.site.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaDao extends JpaRepository<Person, Integer> {

}
