package com.simplon.coupdemaths.utils;

import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUpload {
    public String upload(MultipartFile file) {

        final Slugify slg = Slugify.builder().build();

        try {
            String uploadDirectory = "/public/upload"; // dossier de chargement
            String filename = slg.slugify(file.getOriginalFilename()); // nom fichier chargé
            Path path = Paths.get(".", uploadDirectory).toAbsolutePath(); // absolute path
            File targetFile = new File(path.toString(), filename);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
            return filename;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
