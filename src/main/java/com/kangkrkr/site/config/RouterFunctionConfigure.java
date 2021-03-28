package com.kangkrkr.site.config;

import com.kangkrkr.site.service.webflux.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFunctionConfigure {

    /*
    * 위의 내용을 아래와 같이도 작성 가능하다.
    */
    @Bean
    public RouterFunction<ServerResponse> mRouterFunction(PersonHandler personHandler) {
        return route()
              .GET("/personJpa", personHandler::getAllPersonByJpa)
              .POST("/person/create/{name}", personHandler::createNewPersonByJpa)
              .build();
    }
}
