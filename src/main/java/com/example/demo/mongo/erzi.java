package com.example.demo.mongo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class erzi extends A{
    private String age;


    public static void main(String[] args) {
        erzi e = (erzi) get();
        System.out.println(e.getName());
    }

    public static A get (){
        return new A("sss");
    }
}
