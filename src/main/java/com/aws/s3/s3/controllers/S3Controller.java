package com.aws.s3.s3.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aws.s3.s3.services.IS3Service;

@RestController
public class S3Controller {

    @Autowired
    private IS3Service s3Service;

    @GetMapping("/donwload/{fileName}")
    public String downloadFile(@PathVariable("fileName") String fileName) throws IOException {
        return s3Service.downloadFile(fileName);
    }

    @GetMapping("/list")
    public List<String> getAllObjects() throws IOException {
        return s3Service.listFiles();
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return s3Service.uploadFile(file);
    }

    @PutMapping("/{oldFileName}/{newFileName}")
    public String updateName(@PathVariable("oldFileName") String oldFileName,
            @PathVariable("newFileName") String newFilename) throws IOException {
        return s3Service.renameFile(oldFileName, newFilename);
    }

    @PutMapping("/api/update/{oldFileName}")
    public String updateFile(@RequestParam("file") MultipartFile file, @PathVariable("oldFileName") String oldFileName)
            throws IOException {
        return s3Service.updateFile(file, oldFileName);
    }

    @DeleteMapping("/delete/{fileName}")
    public String deleteFile(@PathVariable("fileName") String fileName) throws IOException {
        return s3Service.deleteFile(fileName);
    }

}
