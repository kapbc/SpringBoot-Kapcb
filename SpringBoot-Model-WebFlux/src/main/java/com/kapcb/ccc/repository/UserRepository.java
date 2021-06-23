package com.kapcb.ccc.repository;

import com.kapcb.ccc.model.po.UserPO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * <a>Title: UserRepository </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 14:55
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<UserPO, Long> {

    Flux<UserPO> getALLByUserIdIn(List<Long> userId);

}
