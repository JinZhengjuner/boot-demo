//package com.example.demo.pojo;
//
//import cn.hutool.core.io.IoUtil;
//import com.alibaba.fastjson.JSON;
//import com.mongodb.bulk.BulkWriteResult;
//import com.mongodb.client.gridfs.model.GridFSFile;
//import lombok.extern.slf4j.Slf4j;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.BulkOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.gridfs.GridFsResource;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.*;
//
//@RestController
//@RequestMapping("/file")
//@Slf4j
//public class MongoGridFsController {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    @GetMapping("/mongo")
//    @Transactional(rollbackFor = Exception.class)
//    public String testMongo() {
//        Map<String,String> map = new LinkedHashMap();
//        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, User.class);
//        List<User> userList = new ArrayList<>();
//        userList.add(new User("001", "Alice", Arrays.asList("a", "b"), 1D));
//        userList.add(new User("002", "Bob", Arrays.asList("c", "d"), 2.4D));
//        bulkOps.insert(userList);
//
////        Query query = new Query(Criteria.where("name").is("张三"));
////        Update update = new Update().set("name", "张三更新了").set("age", 21);
////        bulkOps.updateOne(query, update);
////
////        Query query1 = new Query(Criteria.where("name").is("李四"));
////        Update update1 = new Update().set("name", "李四更新了").set("age", 21).set("qty", 0.1D);
////        bulkOps.updateOne(query1, update1);
//
//        BulkWriteResult execute = bulkOps.execute();
//        log.info(JSON.toJSONString(execute));
//        int i = 1/0;
//        return "success";
//    }
//
//
//        @Autowired
//    private GridFsTemplate gridFsTemplate;
//
//    /**
//     * 保存上传文件
//     * @param file
//     * @return
//     */
//    @PostMapping("/save")
//    public String saveFile(MultipartFile multipartFile) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        try (InputStream inputStream = multipartFile.getInputStream();) {
//            // 获取文件的源名称
//            String fileName = multipartFile.getOriginalFilename();
//            // 进行文件存储
//            ObjectId objectId = gridFsTemplate.store(inputStream, fileName, map);
//            // 返回文件的id
//            return objectId.toHexString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 据id返回文件
//     */
//    public byte[] getFile(String fileId) {
//        // 根据id查询文件
//        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
//        if (gridFSFile == null) {
//            throw new RuntimeException("No file with id: " + fileId);
//        }
//        // 获取流对象
//        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
//        /* 可根据实际需求进行数据的获取 */
//        try {
//            // 获取流中的数据
////			String content = IOUtils.toString(resource.getInputStream(), "UTF-8");
//            // 获取byte[]信息
//            byte[] bytes = IoUtil.readBytes(resource.getInputStream());
//            return bytes;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//
//}
