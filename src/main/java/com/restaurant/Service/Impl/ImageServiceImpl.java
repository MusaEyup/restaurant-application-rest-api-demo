package com.restaurant.Service.Impl;

import com.restaurant.Entity.ItemImages;
import com.restaurant.Repository.ImageRepository;
import com.restaurant.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepo;

    @Override
    public Long storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            // Check if the file's name contains invalid characters


            ItemImages dbFile = new ItemImages(fileName,  file.getBytes());

            return imageRepo.save(dbFile).getId();
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public ItemImages getFile(Long fileId) {
        return imageRepo.findById(fileId).orElse(null);

    }





}
