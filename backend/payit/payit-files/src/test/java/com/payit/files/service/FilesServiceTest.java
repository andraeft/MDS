package com.payit.files.service;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.*;

public class FilesServiceTest {

    @Test
    public void persistFile() {
        FilesService filesService = new FilesService("./uploads/");
        MultipartFile multipartFile = new MockMultipartFile("filename", "filename.txt", "text/plain", "ct".getBytes());
        filesService.persistFile(multipartFile);
    }
}