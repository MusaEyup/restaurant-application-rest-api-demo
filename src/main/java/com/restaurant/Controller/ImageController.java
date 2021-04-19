package com.restaurant.Controller;

import com.restaurant.Context.Response;
import com.restaurant.Entity.ItemImages;
import com.restaurant.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/{fileId:.+}")
    public ItemImages/*ResponseEntity<Resource>*/ downloadFile(@PathVariable Long fileId, HttpServletRequest request) {
        // Load file as Resource
        ItemImages itemImages = imageService.getFile(fileId);
        return itemImages;
        /*return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + itemImages.getImageName() + "\"")
                .body(new ByteArrayResource(itemImages.getPicture()));*/
    }


    @PostMapping("/")
    public Long uploadFile(@RequestParam("file") MultipartFile file) {
        Long image = imageService.storeFile(file);

        /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/image/")
                .path(image.getImageName())
                .toUriString();

        return new Response(image.getImageName(), fileDownloadUri,
                file.getContentType(), file.getSize());*/
        return image;
    }

   /* @PostMapping("/uploadMultipleFiles")
    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/
}
