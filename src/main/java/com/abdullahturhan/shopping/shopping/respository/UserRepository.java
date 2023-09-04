package com.abdullahturhan.shopping.shopping.respository;

import com.abdullahturhan.shopping.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
