package csubbcluj.lisamunteanu.productservice.dao;

import csubbcluj.lisamunteanu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    @Query(value = "select * from products p inner join product_category as pc on p.id=pc.id_product where pc.id_category= :categoryId",nativeQuery = true)
    List<Product> findAllProductsFromCategory(@Param("categoryId") Integer categoryId);

    @Query(value ="select * from products p inner join product_category " +
            "as pc on p.id=pc.id_product inner join categories as cat on pc.id_category=cat.id " +
            "where (p.description like %:keyword%) or (cat.name like %:keyword%) ", nativeQuery = true)
    List<Product> findAllByKeyword(@Param("keyword") String keyword);
}
