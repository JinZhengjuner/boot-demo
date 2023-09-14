package com.example.demo.arthas;

import com.example.demo.controller.test.User;

public class Math {
    public static final int initData = 666;
    public static User user = new User();
    //c语言实现jvm java类加载器

    /**
     * 类加载过程
     * 加载：
     * 验证：验证代码是否正确
     * 准备：静态变量赋默认值
     * 解析：静态链接过程，完成符号到内存地址的转换
     * 初始化：
     * @return
     *
     * 引导类加载器： 支撑java运行最核心的类，JRE/Lib下面的类
     * 扩展类加载器： JRE/lib 下扩展的类包
     * 应用类加载器： 自己写的那些类
     * 自定义加载器：
     */

    public int compute() { //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

}
