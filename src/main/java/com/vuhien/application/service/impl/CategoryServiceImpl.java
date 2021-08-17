package com.vuhien.application.service.impl;

import com.vuhien.application.entity.Category;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.repository.CategoryRepository;
import com.vuhien.application.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 17/08/2021 15:39
 */
@Component
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> categoryPages(Category category, Pageable pageable) {
        return categoryRepository.categoryPages(category.getCategoryName(), pageable);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        Category rs = new Category();
        rs.setCategoryName(category.getCategoryName());
        categoryRepository.save(rs);
        return rs;
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("Danh mục không tồn tại");
        }
        return category.get();
    }

    @Override
    public void updateCategory(Category category, Long id) {
        Optional<Category> rs = categoryRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Danh mục không tồn tại");
        }
        Category cate = rs.get();
        cate.setCategoryName(category.getCategoryName());
        categoryRepository.save(cate);
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("Danh mục không tồn tại");
        }
        int countCategory = categoryRepository.checkMovieInCategory(id);
        if (countCategory > 0) {
            throw new BadRequestException("Có bộ phim thuộc danh mục");
        }
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Lỗi khi xóa danh mục!");
        }
    }
}
