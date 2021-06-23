package com.kapcb.ccc.handler;

import com.kapcb.ccc.model.vo.UserVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <a>Title: UserHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 14:43
 */
public interface UserHandler {

    Mono<UserVO> getUserInfo(Long id);

    Flux<UserVO> getUserInfos(List<Long> id)

    Flux<UserVO> getUserList();

}
