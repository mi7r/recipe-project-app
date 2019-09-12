package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.domain.Recipe;
import com.spring.radek.recipeproject.exceptions.NotFoundException;
import com.spring.radek.recipeproject.exceptions.SaveImageFileException;
import com.spring.radek.recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) throws SaveImageFileException {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(NotFoundException::new);
            Byte[] byteObject = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) {
                byteObject[i++] = b;
            }

            recipe.setImage(byteObject);

            recipeRepository.save(recipe);
        } catch (IOException e) {
            throw new SaveImageFileException("Can not save image file. " + e);
        }

    }
}
