package com.example.demo.zerenlian.reader;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Read {

    @SneakyThrows
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/resources/702");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parse(line);
            }
            fileWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File file = new File("result.txt");;
    private static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    private static void parse(String line) {
        String str = line;
        Pattern pattern = Pattern.compile("E0 07(.*?)AA 55");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String match = matcher.group(1);
            String other = mock(match.trim());
            String result = "2016年" + other;
            System.out.println(result); // 不包含"AA 55"
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(result);
            bw.newLine();
            bw.flush();
        }
    }

    private static String mock(String match) {
        //    "01  月 1D 日 09 小时 14 分       0F 41 61 03 00 D6";
        String[] parts = match.split(" ");
        String month = String.valueOf(Integer.parseInt(parts[0], 16)) + "月" ;
        String day = Integer.parseInt(parts[1], 16) + "日"; // "01"
        String xiaoshi  = Integer.parseInt(parts[2], 16) + "小时";
        String fen  = Integer.parseInt(parts[3], 16) + "分";
        String miao= Integer.parseInt(parts[4], 16) + "秒";


        String weimiao =  parts[5] + " " +  parts[6]+ " " +parts[7]  + " " +parts[8];



//        String str = "41 61 03 00";
        String[] xxx = weimiao.split(" ");

// 将16进制字符串转换为字节数组
        byte[] bytes = new byte[xxx.length];
        for (int i = 0; i < xxx.length; i++) {
            bytes[i] = (byte) Integer.parseInt(xxx[i], 16);
        }

// 反转字节数组
        byte[] reversedBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            reversedBytes[i] = bytes[bytes.length - 1 - i];
        }

// 将字节数组转换为整数
        int microseconds = java.nio.ByteBuffer.wrap(reversedBytes).getInt();

        String result = month + day + xiaoshi +fen + miao + microseconds + "微妙";
        return result;
    }


}
