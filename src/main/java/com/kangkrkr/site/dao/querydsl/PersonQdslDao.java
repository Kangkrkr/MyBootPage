package com.kangkrkr.site.dao.querydsl;

import com.kangkrkr.site.entity.Person;
import com.kangkrkr.site.entity.QPerson;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PersonQdslDao {

    // 생성자 주입 기반으로
    private final JPAQueryFactory queryFactory;

    public List<Person> getPersons() {
        QPerson p = QPerson.person;
        List<Person> persons = queryFactory.selectFrom(p)
                                        .where(p.idx.eq(1))
                                        .orderBy(p.name.desc())
                                        .fetch();

        return persons;
    }
}
