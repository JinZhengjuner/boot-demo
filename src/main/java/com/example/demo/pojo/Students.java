package com.example.demo.pojo;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Data
public class Students {

    private  static List<Student> students = Arrays.asList(
            new Student(1l,"张三",1l,1l),
            new Student(2l,"李四",2l,2l),
            new Student(3l,"王五",3l,3l),
            new Student(4l,"赵六",4l,4l)
    );

    public Student findByName(String name) {
        return find(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return name.equals(student.getName());
            }
        });
    }

    public Student findBySno(long sno) {
        return find(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return sno == student.getSno();
            }
        });
    }

    public Student findById(long id) {
        return find(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return id == student.getId();
            }
        });
    }

    public Student find(Predicate predicate) {
        for (Student student : students) {
            if (predicate.test(student)){
                return student;
            }
        }
        return null;
    }

    static Predicate byName(String name){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return name.equals(student.getName());
            }
        };
    }

    static Predicate<Student> byName2(String name){
        return studnet -> studnet.getName().equals(name);
    }

    static Predicate bySno(long sno){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return sno == student.getSno();
            }
        };
    }
    static Predicate byId(long id){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return id == student.getId();
            }
        };
    }

    static Predicate and(Predicate... predicates){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                for (Predicate predicate : predicates) {
                    if (!predicate.test(student)){
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.add(4);


//        Student student = students.find(byName("张三"));
//        System.out.println(student);
//        Student student1 = students.find(bySno(1l));
//        System.out.println(student1);
//        Student student2 = students.find(byId(2l));
//        System.out.println(student2);
//        System.out.println("------");
//        Student student3 = students.find(and(byName("张三"), bySno(2l)));
//        System.out.println(student3);
    }

}
