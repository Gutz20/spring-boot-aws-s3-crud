package com.aws.s3.s3.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IS3Service {
    String uploadFile(MultipartFile file) throws IOException;

    String downloadFile(String fileName) throws IOException;

    List<String> listFiles() throws IOException;

    String deleteFile(String fileName) throws IOException;

    String renameFile(String oldFileName, String newFileName) throws IOException;

    String updateFile(MultipartFile file, String oldFileName) throws IOException;
}
