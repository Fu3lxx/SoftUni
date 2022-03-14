package com.example.xmlexercise.service;

import com.example.xmlexercise.models.dto.categoryDto.CategorySeedDto;
import com.example.xmlexercise.models.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    Long getCount();

    Set<Category> getRandomCategories();
}
