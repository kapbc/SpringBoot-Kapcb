package com.kapcb.ccc.exception;

/**
 * <a>Title:SystemException</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 11:04
 */
public class SystemException extends RuntimeException{
    private static final long serialVersionUID = 8415167801186847670L;


    public SystemException (){
        super("系统异常！");
    }
}
