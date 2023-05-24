package com.freecharge.user.service.userService.repositories;

import com.freecharge.user.service.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
