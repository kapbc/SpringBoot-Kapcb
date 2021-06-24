package com.kapcb.ccc.handler.impl;

import com.kapcb.ccc.handler.UserHandler;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.model.vo.UserVO;
import com.kapcb.ccc.repository.UserRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * <a>Title: UserHandlerImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 15:07
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {

    private final UserRepository userRepository;

    @Override
    public Mono<UserVO> getUserInfo(Long id) {
        Mono<UserPO> orElse = Option.of(userRepository.findById(id)).getOrElse(Mono.fromSupplier(UserPO::new));
        return orElse.filter(Objects::nonNull).map(s -> UserVO.builder()
                .userId(s.getUserId())
                .sex(s.getSex())
                .birthday(s.getBirthday())
                .firstName(s.getFirstName())
                .lastName(s.getLastName())
                .password(s.getPassword()).build());
    }

    @Override
    public Flux<UserVO> getUserInfos(List<Long> id) {
        Flux<UserPO> orElse = Option.of(userRepository.getALLByUserIdIn(id)).getOrElse(Flux.just(new UserPO()));
        return orElse.switchIfEmpty(Flux.just(new UserPO())).map(s -> UserVO.builder()
                .userId(s.getUserId())
                .sex(s.getSex())
                .birthday(s.getBirthday())
                .firstName(s.getFirstName())
                .lastName(s.getLastName())
                .password(s.getPassword()).build());
    }

    @Override
    public Flux<UserVO> getUserList() {
        Flux<UserPO> all = userRepository.findAll();
        return null;
    }
}
