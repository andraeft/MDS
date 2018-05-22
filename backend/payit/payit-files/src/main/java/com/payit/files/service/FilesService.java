package com.payit.files.service;

import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class FilesService {

    private static final Logger logger = LoggerFactory.getLogger(FileSerializer.class);

    private Map<String, MultipartFile> filesCache = new HashMap<>();

    private String uploadPath = "./uploads/";

    public String cacheFile(MultipartFile file) {
        String fileId = UUID.randomUUID().toString();
        filesCache.put(fileId, file);
        return fileId;
    }

    public void persistFile(String cacheFileId) {
        MultipartFile file = filesCache.get(cacheFileId);
        persistFile(file, cacheFileId);
        filesCache.remove(cacheFileId);
    }

    public String persistFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString();
        persistFile(file, fileName);
        return fileName;
    }

    public MultipartFile getCachedFile(String cacheFileId) {
        return filesCache.get(cacheFileId);
    }

    private void persistFile(MultipartFile file, String fileName) {
        try {
            if (!file.isEmpty()) {
                InputStream is = file.getInputStream();

                Files.copy(is, Paths.get(uploadPath + fileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            logger.error("Could not persist file ", ex);
        }
    }
}
