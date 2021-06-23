package com.kapcb.ccc.handler.impl;

import com.kapcb.ccc.handler.UserHandler;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.model.vo.UserVO;
import com.kapcb.ccc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<UserPO> getUserInfo(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<UserPO> getUserInfos(List<Long> id) {
        return userRepository.getALLByUserIdIn(id);
//        return allByUserIdIn.collectList().map(s -> s.stream().map(e -> UserVO.builder()
//                .userId(e.getUserId())
//                .firstName(e.getFirstName())
//                .lastName(e.getLastName())
//                .password(e.getPassword())
//                .birthday(e.getBirthday())
//                .sex(e.getSex()).build()).findAny().orElse(null)).flux();
    }

    @Override
    public Flux<UserVO> getUserList() {
        Flux<UserPO> all = userRepository.findAll();
        return null;
    }
}
