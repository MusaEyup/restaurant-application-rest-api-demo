package com.restaurant.Service;

import com.restaurant.Entity.ItemImages;
import com.restaurant.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
     Long storeFile(MultipartFile file);
     ItemImages getFile(Long fileId);
     void deleteImageById(Long imageId);
}
