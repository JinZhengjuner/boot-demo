package com.example.demo.controller.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Data
@Slf4j
public class Person {
    private String name;
    private byte[] data;

    public static void main(String[] args) throws IOException {

        log.warn("warn..............");
        for (int i = 0; i < 100; i++) {
            int j = (int)(Math.random() * 5 + 5);
            System.out.println(j);
        }
        log.error("error..............");
    }

    private static void 没() throws IOException {
        String jsonString = "{\"name\":\"John\",\"data\":\"SGVsbG8gd29ybGQh\"}";
        Person person = JSON.parseObject(jsonString, Person.class);
        fetchTextFromZipBytes(person.getData(), "a");
    }

    public static String fetchTextFromZipBytes(byte[] zipBytes, String name) throws IOException {
        String result = null;
        File tempFile = null;
        try{
            tempFile = new File(UUID.randomUUID() +".zip");
            FileUtils.writeByteArrayToFile(tempFile, zipBytes);

            ZipFile zipFile = new ZipFile(tempFile);
            ZipEntry entry = zipFile.getEntry(name);
            if(null == entry) {
                return null;
            }
            try (
                    InputStream ins = zipFile.getInputStream(entry);
            ){
                // 流字节数
                result = IOUtils.toString(ins, "UTF-8");
            }
        }catch (Exception e){
            log.error("zip字节流解压缩 {} 文本文件异常", name, e);
            throw e;
        }finally {
            // 删除临时文件
//            if(null != tempFile){
//                tempFile.delete();
//            }
        }


        return result;
    }
}
