package com.vuhien.application.repository;

import com.vuhien.application.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by VuHien96 on 17/08/2021 15:45
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("FROM Category c " +
            "WHERE c.categoryName like %:name%")
    Page<Category> categoryPages(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT count(cm.category_id) " +
            "FROM category_movie cm " +
            "WHERE cm.category_id = ?1 ",nativeQuery = true)
    int checkMovieInCategory(Long id);
}
