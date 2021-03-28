package com.kangkrkr.site.dao.mybatis;

import com.kangkrkr.site.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonDao {
    List<Person> getPerson();
}
