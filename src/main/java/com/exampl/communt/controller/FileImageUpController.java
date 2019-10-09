package com.exampl.communt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//图片上传
@Controller
public class FileImageUpController {
    private static String UPLOADED_FOLDER = "D://temp1//";
    @GetMapping("/upImage")
    public String up(){
        return "fromFile";
    }

    @PostMapping(value = "/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   Model redirectAttributes){
        if (file.isEmpty()){
            redirectAttributes.addAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes=file.getBytes();
            File file1=new File(UPLOADED_FOLDER);
            if (!file1.exists()){
                file1.mkdirs();
            }

            File file2=new File(UPLOADED_FOLDER+file.getOriginalFilename());
            FileOutputStream fileOutputStream=new FileOutputStream(file2);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            redirectAttributes.addAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadStatus";
    }
}
