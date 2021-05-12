package com.kapcb.ccc.common.configuration.call;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Task Callable <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/12 22:35
 */
public class TaskCallable implements Callable<List<String>> {

    private List<String> list;

    @Override
    public List<String> call() throws Exception {
        List<String> listRe = new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            //含有‘4599’的字符串都返回
            if(list.get(i).contains("399")){
                listRe.add(list.get(i));
            }
        }
        return listRe;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
