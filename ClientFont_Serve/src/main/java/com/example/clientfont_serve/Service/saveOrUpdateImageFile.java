package com.example.clientfont_serve.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class saveOrUpdateImageFile {

    //定义上传文件的存放位置
    private String filePath = "G:/全（栈）干/block-chain_-water-mark/clockChain_waterMark_IFPS_Dome/img/Clientsendimage";

    //保存上传的图片
    public String saveOrUpdateImageFile(MultipartFile image) {
        //判断文件夹是否存在,不存在则创建
        File file = new File(filePath);

        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFileName = image.getOriginalFilename();//获取原始图片的扩展名
        String newFileName = originalFileName;
        String newFilePath = filePath + newFileName; //新文件的路径
        System.out.println(newFilePath);

        try {
            image.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件
            return newFileName;
        } catch (IllegalStateException e) {
            return "error";
        } catch (IOException e1) {
            return "error";
        }
    }
}

