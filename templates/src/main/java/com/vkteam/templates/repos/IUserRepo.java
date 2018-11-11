package com.vkteam.templates.repos;

import com.vkteam.templates.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByPhoneNumber(String phoneNumber);
}
