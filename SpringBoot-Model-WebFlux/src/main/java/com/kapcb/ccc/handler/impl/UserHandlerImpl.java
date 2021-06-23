package com.kapcb.ccc.handler.impl;

import com.kapcb.ccc.handler.UserHandler;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.model.vo.UserVO;
import com.kapcb.ccc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
        Mono<UserPO> userPOMono = userRepository.findById(id);
        UserPO userPO = userPOMono.block();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userPO, userVO);
        return Mono.just(userVO);
    }

    @Override
    public Flux<UserVO> getUserInfos(List<Long> id) {
        Flux<UserPO> allByUserIdIn = userRepository.getALLByUserIdIn(id);
        List<UserPO> userPOList = allByUserIdIn.collectList().block();
        return Flux.fromStream(userPOList.stream().filter(Objects::nonNull).map(s -> UserVO.builder()
                .userId(s.getUserId())
                .firstName(s.getFirstName())
                .lastName(s.getLastName())
                .password(s.getPassword())
                .birthday(s.getBirthday())
                .sex(s.getSex()).build()));
    }

    @Override
    public Flux<UserVO> getUserList() {
        Flux<UserPO> all = userRepository.findAll();
        return null;
    }
}
