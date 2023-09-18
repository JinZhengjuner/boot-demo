package com.example.demo.arthas.other;

import sun.misc.Launcher;

import java.net.URL;

/**
 *      * 引导类加载器： 支撑java运行最核心的类，JRE/Lib下面的类
 *      * 扩展类加载器： JRE/lib 下扩展的类包
 *      * 应用类加载器： 自己写的那些类
 *      * 自定义加载器：
 */

public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());

        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);
        System.out.println();
        System.out.println("bootstrapLoader加载以下文件:");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }

        System.out.println();
        System.out.println("extClassloader加载以下文件:");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件:");
        System.out.println(System.getProperty("java.class.path"));

    }
}

