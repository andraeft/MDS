package com.payit.files.service;

import com.payit.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FilesController {

    private final FilesService filesService;

    @PostMapping(value = "/cache")
    public String cacheFile(@RequestParam("file") MultipartFile file) {
        return filesService.cacheFile(file);
    }

    @PostMapping(value = "/save")
    public String saveFile(@RequestParam("file") MultipartFile file) {
        return filesService.persistFile(file);
    }

    @GetMapping(value = "/{fileId}")
    public void getFile(@PathVariable String fileId, HttpServletResponse response) throws NotFoundException, IOException {
        File file = filesService.getFile(fileId);
        try (InputStream is = new FileInputStream(file)) {
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            IOUtils.copy(is, response.getOutputStream());
        } catch (IOException e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getWriter().append("Problem writing file");
        }
    }
}
