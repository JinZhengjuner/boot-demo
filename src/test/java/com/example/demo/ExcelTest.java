package com.example.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.example.demo.pojo.StockCheck;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ExcelTest {
    @Test
    public void test2(){
        try (FileChannel channel = new FileInputStream("a.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            channel.read(buffer);
            buffer.flip();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws FileNotFoundException {
        // 创建工作簿、工作表和样式
        FileOutputStream outputStream = new FileOutputStream("a.xlsx");
        ExcelWriter writeWorkbook = EasyExcel.write(outputStream).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        WriteCellStyle headerStyle = new WriteCellStyle();

        // 写入数据
        ExcelWriterBuilder writerBuilder = EasyExcel.write(outputStream);
        ExcelWriterSheetBuilder sheetBuilder = writerBuilder.sheet();
        sheetBuilder.registerWriteHandler((WriteHandler) headerStyle);
        sheetBuilder.head(StockCheck.class); // 写入表头
        List<StockCheck> stockCheckList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StockCheck stockCheck = new StockCheck(1l,"code"+i,"barcode"+i,1.0d,1.0d,1l,1l,"sku"+i);
            stockCheckList.add(stockCheck);
        }
        sheetBuilder.doWrite(stockCheckList); // 写入数据


    }

    @Test
    public void test(){
        try {
            List<StockCheck> stockCheckList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                StockCheck stockCheck = new StockCheck(1l,"code"+i,"barcode"+i,1.0d,1.0d,1l,1l,"sku"+i);
                stockCheckList.add(stockCheck);
                System.out.println(stockCheck);
            }

//            String fileName = stockCheckList.get(0).getEntId() + "可用库存差异"+ System.currentTimeMillis() +".xlsx";
//            log.info("库存检查，差异库存生成excel，fileName:{}, stockCheckList:{}", fileName, stockCheckList);
////            File file = new File(fileName);
//            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//            EasyExcel.write(fileOutputStream, StockCheck.class)
//                    .sheet("Sheet1")
//                    .doWrite(stockCheckList);

//            Path path = Paths.get(fileName);
//            Files.delete(path);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
}
