package com.imshare.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.imshare.models.Images;
import com.imshare.repositories.ImagesRepository;

@Service
public class ImagesService {

    @Autowired
    ImagesRepository imagesRepository;

    private String generateRandomFilename() {
        char[] characters = new char[26];
        // ASCII characters from lowercase a(97) to z(122)
        char ASCII = 97;
        for(int i = 0; i < characters.length; i++) {
            characters[i] = ASCII;
            ASCII++;
        }
        String filename = "";
        for(int i = 0; i <= 8; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(characters.length-1-0);
            filename += characters[randomIndex];
        }
        return filename;
    }

    private String getImageFormat(MultipartFile file) {
        String mimeType = file.getContentType();
        String[] mimeTypeArray = mimeType.split("/");
        return mimeTypeArray[1];
    }

    private void writeToDir(MultipartFile file, String filename) throws IOException {
        File newFile = new File(Paths.get("").toAbsolutePath().toString() + "/src/main/resources/static/" + filename);
        file.transferTo(newFile);
    }
    
    public Images saveImage(MultipartFile file) {
        String randomFilename = String.format("%s.%s", generateRandomFilename(), getImageFormat(file));
        Images newImage = new Images();
        newImage.setDataCreated(Instant.now().getEpochSecond());
        newImage.setFilename(randomFilename);
        try {
            writeToDir(file, randomFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Images savedImage = imagesRepository.save(newImage);
        return savedImage;
    }
}
