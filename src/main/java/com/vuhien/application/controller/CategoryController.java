package com.vuhien.application.controller;

import com.vuhien.application.entity.Category;
import com.vuhien.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by VuHien96 on 17/08/2021 16:32
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/search")
    public ResponseEntity<Object> categoryPages(@RequestBody Category category, Pageable pageable) {
        Page<Category> categories = categoryService.categoryPages(category, pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category) {
        Category rs = categoryService.createCategory(category);
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        categoryService.updateCategory(category, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
