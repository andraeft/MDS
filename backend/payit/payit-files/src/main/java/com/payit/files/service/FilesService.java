package com.payit.files.service;

import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.payit.common.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FilesService {

    private static final Logger logger = LoggerFactory.getLogger(FileSerializer.class);

    private Map<String, MultipartFile> filesCache = new HashMap<>();

    private final String uploadPath;

    public FilesService(@Value("${upload.files.path}") String uploadPath) {
        this.uploadPath = uploadPath;
    }



    String cacheFile(MultipartFile file) {
        String fileId = UUID.randomUUID().toString();
        filesCache.put(fileId, file);
        return fileId;
    }

    void persistFile(String cacheFileId) {
        MultipartFile file = filesCache.get(cacheFileId);
        persistFile(file, cacheFileId);
        filesCache.remove(cacheFileId);
    }

    String persistFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString();
        persistFile(file, fileName);
        return fileName;
    }

    MultipartFile getCachedFile(String cacheFileId) {
        return filesCache.get(cacheFileId);
    }

    File getFile(String fileId) throws NotFoundException {
        File file = filePath(fileId).toFile();
        if (!file.exists()) throw new NotFoundException();
        return file;
    }

    private void persistFile(MultipartFile file, String fileName) {
        try {
            if (!file.isEmpty()) {
                Path path = filePath(fileName);

                if (!path.getParent().toFile().exists()) {
                    Files.createDirectories(path.getParent());
                }

                Files.write(path, file.getBytes());
            }
        } catch (IOException ex) {
            logger.error("Could not persist file ", ex);
        }
    }

    private Path filePath(String fileName) {
        return Paths.get(uploadPath + fileName);
    }
}
