package com.webapps.recipe.controllers;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.command.RecipeCommand;
import com.webapps.recipe.domain.Category;
import com.webapps.recipe.exceptions.NotFoundException;
import com.webapps.recipe.services.CategoryService;
import com.webapps.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class RecipeController {

    private RecipeService recipeService;
    private CategoryService categoryService;


    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;

    }


    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());


        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        RecipeCommand rc = recipeService.findCommandById(Long.valueOf(id));


        model.addAttribute("recipe",rc);
        model.addAttribute("categoriesList",categoryService.listAllCategories());
        model.addAttribute("selectedCategories",rc.getCategories());
        return "recipe/recipeform";
    }


    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }


    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        log.debug("Delete recipe with id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("404error");
        return modelAndView;
    }
}
