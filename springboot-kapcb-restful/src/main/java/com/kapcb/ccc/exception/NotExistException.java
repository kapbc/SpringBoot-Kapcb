package com.kapcb.ccc.exception;

/**
 * <a>Title:NotExistException</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 13:58
 */
public class NotExistException extends RuntimeException {
    private static final long serialVersionUID = -2223984447227539265L;

    public NotExistException() {
        super("用户名不存在异常");
    }
}
