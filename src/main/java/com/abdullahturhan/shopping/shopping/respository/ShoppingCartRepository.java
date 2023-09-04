package com.abdullahturhan.shopping.shopping.respository;

import com.abdullahturhan.shopping.shopping.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
