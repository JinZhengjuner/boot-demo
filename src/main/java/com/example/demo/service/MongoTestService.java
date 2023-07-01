package com.example.demo.service;


import com.example.demo.pojo.MongoTest;
import org.springframework.stereotype.Service;

@Service
public interface MongoTestService{

    /**
     * 创建对象
     */
    public void saveTest(MongoTest test);

    /**
     * 根据用户名查询对象
     * @return
     */
    public MongoTest findTestByName(String name);

    /**
     * 更新对象
     */
    public void updateTest(MongoTest test);

    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(Integer id) ;

    String batchInsert();

    void exceptionTest();

    void update();
}
