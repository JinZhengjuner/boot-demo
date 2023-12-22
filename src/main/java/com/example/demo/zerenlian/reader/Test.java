package com.example.demo.zerenlian.reader;

public class Test {
    public static void main(String[] args) {


         //    "01  月 1D 日 09 小时 14 分       0F 41 61 03 00 D6";
        String str = "01 1D 09 14 0F 41 61 03 00 D6";
        String[] parts = str.split(" ");
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

        String result = month + day + xiaoshi +fen + miao + weimiao + "微妙";
    }
}
