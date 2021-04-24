package com.kapcb.ccc.component;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: FileLoadComponent </a>
 * <a>Author: kapcb <a>
 * <a>Description: File Load Component <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 12:38
 */
@Component
public class FileLoadComponent {


    @Async
    public void initialLoadData() {

        List<String> keywordList = new ArrayList<>();

        try (InputStream inputStream = Files.newInputStream(Paths.get(""))) {
            EasyExcel.read(inputStream, String.class, new AnalysisEventListener<String>() {

                @Override
                public void invoke(String data, AnalysisContext analysisContext) {
                    keywordList.add(data);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    System.out.println("the data load finished");
                }
            }).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("keywordList = " + keywordList);

    }
}
