package com.abdullahturhan.shopping.shopping.respository;

import com.abdullahturhan.shopping.shopping.entity.Product;
import com.abdullahturhan.shopping.shopping.enumType.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findByCategory(Category category, Pageable pageable);


    @Override
    Page<Product> findAll(Pageable pageable);
}
