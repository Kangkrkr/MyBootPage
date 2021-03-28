package com.kangkrkr.site.util;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerResponse.BodyBuilder;

import reactor.core.CorePublisher;
import reactor.core.publisher.Mono;

public class ResponsUtil {
    
    private static BodyBuilder createJsonBodyBuilder() {
        return ServerResponse.ok()
                             .contentType(MediaType.APPLICATION_JSON);
    }

    public static <C extends Class<?>, P extends CorePublisher<?>> Mono<ServerResponse> createMonoResponse(P p, C c) {
        return createJsonBodyBuilder().body(p, c);
    }
}
