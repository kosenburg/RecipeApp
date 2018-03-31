package com.guru.mvc.gurumvc.controllers;

import com.guru.mvc.gurumvc.domain.Category;
import com.guru.mvc.gurumvc.domain.UnitOfMeasure;
import com.guru.mvc.gurumvc.repositories.CategoryRepository;
import com.guru.mvc.gurumvc.repositories.UnitOfMeasureRepository;
import com.guru.mvc.gurumvc.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
