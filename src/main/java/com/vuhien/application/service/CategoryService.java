package com.vuhien.application.service;

import com.vuhien.application.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 17/08/2021 15:39
 */
@Service
public interface CategoryService {
    Page<Category> categoryPages(Category category, Pageable pageable);
    List<Category> getAllCategory();
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    void updateCategory(Category category, Long id);
    void deleteCategory(Long id);
}
