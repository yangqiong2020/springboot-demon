package yq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {
    /**
     * 处理文件上传
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/fileUploadController")  //如果前台页面filename和上传方法中的属性名不一样的时候，就要加上@RequestParam("filename") 这里的参数也要和前台传来的一样
    public Map<String,Object> fileUpload(@RequestParam("filename") MultipartFile fileName) throws IOException {
        System.out.println(fileName.getOriginalFilename());
        fileName.transferTo(new File("e:/"+fileName.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }
}
