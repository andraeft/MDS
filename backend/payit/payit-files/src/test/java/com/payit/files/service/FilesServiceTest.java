package com.payit.files.service;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static org.junit.Assert.*;

public class FilesServiceTest {

    @Test
    public void persistFile() {
        String path = "./uploads/";
        FilesService filesService = new FilesService(path);
        MultipartFile multipartFile = new MockMultipartFile("filename", "filename.txt", "text/plain", "ct".getBytes());
        String filename = filesService.persistFile(multipartFile);
        File f = new File(path + filename);
        assertTrue(f.exists());
        f.delete();
    }
}