package com.webapps.recipe.services;

import com.webapps.recipe.domain.Recipe;
import com.webapps.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl( RecipeRepository recipeService) {
        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            recipe.setImage(boxBytes(file));
            recipeRepository.save(recipe);
        } catch (IOException e) {
            log.error("An error occurred", e);
            e.printStackTrace();
        }
    }

    private Byte[] boxBytes(MultipartFile file) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];

        int i = 0;

        for (byte b : file.getBytes()){
            byteObjects[i++] = b;
        }

        return byteObjects;
    }
}
