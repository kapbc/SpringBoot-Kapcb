package com.kapcb.ccc.controller;

import com.kapcb.ccc.handler.UserHandler;
import com.kapcb.ccc.model.po.UserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a>Title: UserController </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * <p>
 * Mono 和 Flux 适用于两个场景，即：
 * Mono：实现发布者，并返回 0 或 1 个元素，即单对象。
 * Flux：实现发布者，并返回 N 个元素，即 List 列表对象。
 * 有人会问，这为啥不直接返回对象，比如返回 City/Long/List。
 * 原因是，直接使用 Flux 和 Mono 是非阻塞写法，相当于回调方式。
 * 利用函数式可以减少了回调，因此会看不到相关接口。这恰恰是 WebFlux 的好处：集合了非阻塞 + 异步
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 15:03
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserHandler userHandler;

    @GetMapping(value = "info/{id}")
    public Mono<UserPO> info(@PathVariable("id") Long id) {
//        return Mono.create(monoSink -> monoSink.success(userHandler.getUserInfo(id)));
        return userHandler.getUserInfo(id);
    }

    @GetMapping(value = "infos/{ids}")
    public Flux<UserPO> infos(@PathVariable(value = "ids") String ids) {
        return userHandler.getUserInfos(Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()));
    }
}
