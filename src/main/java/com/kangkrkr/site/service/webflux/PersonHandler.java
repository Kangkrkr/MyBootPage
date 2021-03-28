package com.kangkrkr.site.service.webflux;

import com.kangkrkr.site.dao.jpa.PersonJpaDao;
import com.kangkrkr.site.domain.ResponseVO;
import com.kangkrkr.site.entity.Person;
import com.kangkrkr.site.util.ResponsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
public class PersonHandler {

    private static final String CACHE_KEY_PERSON = "person";

    // Orable DB Repository
    @Autowired
    private PersonJpaDao personDao;

    public Mono<ServerResponse> getAllPersonByJpa(ServerRequest request) {
        List<Person> memberList = personDao.findAll();

        return ResponsUtil.createMonoResponse(Flux.fromStream(memberList.stream()), Person.class);
    }

    @Transactional(transactionManager = "jpaTransactionManager")
    public Mono<ServerResponse> createNewPersonByJpa(ServerRequest request) {
        Optional<String> opName = Optional.ofNullable(request.pathVariable("name"));

        // isPresent()-get() 대신 orElse()/orElseGet()/orElseThrow() 사용 권장
        String name = opName.orElseThrow(
            () -> new IllegalArgumentException("이름이 입력되지 않았습니다.")
        );

        // save(Entity)
        final Person person = new Person();
        person.setName(name);
        person.setEmail("kangkrkr@naver.com");
        person.setPasswd("12345");

        Optional<Person> opSavedMember = Optional.ofNullable(personDao.saveAndFlush(person));
        opSavedMember.orElseThrow(() -> new NullPointerException("정상적으로 멤버가 생성되지 않았습니다."));

        ResponseVO<Person> responseVo = ResponseVO.<Person>of()
                                        .responseStatus(HttpStatus.OK)
                                        .message("정상적으로 멤버 등록 되었습니다.")
                                        .data(opSavedMember.orElse(new Person()))
                                        .build();

        return ResponsUtil.createMonoResponse(Mono.just(responseVo), ResponseVO.class);
    }
}
