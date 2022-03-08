package com.example.jsonexercise.services.impl;

import com.example.jsonexercise.model.dto.CategorySeedDto;
import com.example.jsonexercise.model.entity.Category;
import com.example.jsonexercise.repository.CategoryRepository;
import com.example.jsonexercise.services.CategoryService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonexercise.constant.GlobalConstant.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE = "categories.json";
    private final Gson gson;
    private final ValidationUtil validator;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(Gson gson, ValidationUtil validator, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.gson = gson;
        this.validator = validator;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }
        String fileContent =Files.readString(Path.of(RESOURCES_FILE_PATH + CATEGORY_FILE));

        CategorySeedDto[] categorySeedDtos = gson
                .fromJson(fileContent,CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validator::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> randomCategories = new HashSet<>();
        int categoryCount = ThreadLocalRandom.current().nextInt(1,3);
        long totalCategories = categoryRepository.count();

        for (int i = 0; i < categoryCount; i++) {
            Long randomCategoryId = ThreadLocalRandom.current().nextLong(1,totalCategories + 1);

            randomCategories.add(categoryRepository.findById(randomCategoryId).orElse(null));
        }

        return randomCategories;
    }
}
