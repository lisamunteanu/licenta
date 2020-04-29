package csubbcluj.lisamunteanu.authservice.dao;

import csubbcluj.lisamunteanu.authservice.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<CustomUser,Integer> {

    @Query(value ="select * from customers c where c.username = :username limit 1" ,nativeQuery = true)
    Optional<CustomUser> findByUsername(@Param("username") String username);
}
