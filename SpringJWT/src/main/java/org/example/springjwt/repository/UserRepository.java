package org.example.springjwt.repository;

import org.example.springjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByUsername(String username);//username 존재 하는지 확인


    //유저 조회
    UserEntity findByUsername(String username);
}
