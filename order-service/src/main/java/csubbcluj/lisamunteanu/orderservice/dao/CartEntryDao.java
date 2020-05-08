package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartEntryDao extends JpaRepository<CartEntry, Integer> {
    @Query(value = "select * from cart_entries c where c.product_id = :productId limit 1", nativeQuery = true)
    Optional<CartEntry> findByProductId(@Param("productId") Integer productId);

    @Query(value = "select ce.id,ce.product_id,ce.name,ce.image,ce.brand,ce.description,cc.quantity from cart_entries ce" +
            " inner join cart_to_cartentry cc on ce.id = cc.cart_entry_id" +
            " inner join carts c on c.id=cc.cart_id where c.user_id=:userId", nativeQuery = true)
    List<Object[]> findByUserId(@Param("userId") Integer userId);

    @Query(value = "select * from cart_entries c inner join cart_to_cartentry cc on c.id=cc.cart_entry_id where cc.cart_id = :cartId", nativeQuery = true)
    List<CartEntry> getAllByCartId(@Param("cartId") Integer cartId);
}
