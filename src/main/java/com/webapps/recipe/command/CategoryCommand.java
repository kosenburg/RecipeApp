package com.webapps.recipe.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class CategoryCommand {
    private Long id;
    private String description;
}
