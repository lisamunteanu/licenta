package csubbcluj.lisamunteanu.productservice.dao;

import csubbcluj.lisamunteanu.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query(value = "select * from categories c where c.supercategory=:superCategory",nativeQuery = true)
    List<Category> getCategoryBySuperCategory(@Param("superCategory") String superCategory);
}
