package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.models.dto.categoryDto.CategorySeedDto;
import com.example.xmlexercise.models.entity.Category;
import com.example.xmlexercise.repository.CategoryRepository;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories.stream().filter(validationUtil::isValid).map(category-> modelMapper.map(category, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public Long getCount() {
        return categoryRepository.count();
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int randomCount = ThreadLocalRandom.current().nextInt(1,4);
        long categoryCount = categoryRepository.count();

        for (int i = 0; i < randomCount; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1,categoryCount + 1);
            categories.add(categoryRepository.findById(randomId).orElse(null));

        }
        return categories;
    }
}
