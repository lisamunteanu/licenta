package csubbcluj.lisamunteanu.productservice.dao;

import csubbcluj.lisamunteanu.productservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDao extends JpaRepository<Price,Integer> {
}
