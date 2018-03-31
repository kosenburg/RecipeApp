package com.guru.mvc.gurumvc.repositories;

import com.guru.mvc.gurumvc.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
