package com.islide.blog.controller;

import com.islide.blog.entity.Users;
import com.islide.blog.service.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;
    @RequestMapping("/index")
    public Mono<String> index() {
        return Mono.just("hello world");
    }

    @RequestMapping("/index2")
    public Flux<Users> index2() {
        List<Users> list = userService.list();
        return Flux.fromIterable(list);
    }

    @RequestMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> testFlux() {
        return Flux.just(ServerSentEvent.builder().event("message").build());
    }
}
