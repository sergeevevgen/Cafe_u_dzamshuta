package com.cafe.cafe.service;

import com.cafe.cafe.model.Category;
import com.cafe.cafe.repository.CategoryRepository;
import com.cafe.cafe.util.validation.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryService {
    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository repository;

    private final ValidatorUtil validatorUtil;

    public CategoryService(CategoryRepository repository, ValidatorUtil validatorUtil) {
        this.repository = repository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Category addCategory(String name, String description) {

    }
}
