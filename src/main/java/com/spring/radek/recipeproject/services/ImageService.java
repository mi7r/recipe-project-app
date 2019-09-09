package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.exceptions.SaveImageFileException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file) throws SaveImageFileException;
}
