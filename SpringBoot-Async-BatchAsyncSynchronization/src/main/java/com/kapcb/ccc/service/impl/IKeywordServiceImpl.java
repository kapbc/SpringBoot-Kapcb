package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IKeywordService;
import org.springframework.stereotype.Service;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/11 22:45
 */
@Service
public class IKeywordServiceImpl implements IKeywordService {

    @Override
    public void insertKeyword(String keyword) {
        System.out.println("keyword = " + keyword);
    }

}
