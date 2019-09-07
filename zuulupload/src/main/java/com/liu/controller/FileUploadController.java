package com.liu.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author liulei
 * @Description 文件上传控制层
 * @create 2017/10/26 10:59
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File origin = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, origin);
        return origin.getAbsolutePath();
    }
}
