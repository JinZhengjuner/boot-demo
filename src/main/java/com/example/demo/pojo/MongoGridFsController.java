package com.example.demo.pojo;

import cn.hutool.core.io.IoUtil;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@RestController("/file")
public class MongoGridFsController {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    /**
     * 保存上传文件
     * @param file
     * @return
     */
    @PostMapping("/save")
    public String saveFile(MultipartFile multipartFile) {
        HashMap<String, String> map = new HashMap<String, String>();
        try (InputStream inputStream = multipartFile.getInputStream();) {
            // 获取文件的源名称
            String fileName = multipartFile.getOriginalFilename();
            // 进行文件存储
            ObjectId objectId = gridFsTemplate.store(inputStream, fileName, map);
            // 返回文件的id
            return objectId.toHexString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 据id返回文件
     */
    public byte[] getFile(String fileId) {
        // 根据id查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        if (gridFSFile == null) {
            throw new RuntimeException("No file with id: " + fileId);
        }
        // 获取流对象
        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
        /* 可根据实际需求进行数据的获取 */
        try {
            // 获取流中的数据
//			String content = IOUtils.toString(resource.getInputStream(), "UTF-8");
            // 获取byte[]信息
            byte[] bytes = IoUtil.readBytes(resource.getInputStream());
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
