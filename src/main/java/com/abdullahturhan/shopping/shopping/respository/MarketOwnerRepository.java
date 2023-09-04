package com.abdullahturhan.shopping.shopping.respository;

import com.abdullahturhan.shopping.shopping.entity.MarketOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketOwnerRepository extends JpaRepository<MarketOwner,Long> {
}
