package com.example.lte.repo;

import com.example.lte.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepo
 * JpaRepository jpa标准CRUD用法
 * JpaSpecificationExecutor 多条件动态SQL查询用
 *
 * @author lzh
 * @date 2020/10/13 - 13:43
 */
@Repository
public interface UserRepo extends JpaSpecificationExecutor<UserEntity>, JpaRepository<UserEntity, Long> {

    List<UserEntity> findByNameIsLike(String name);

    UserEntity findByAccount(String account);

    UserEntity findByAccountAndPassword(String account, String password);

    @Query("SELECT O FROM UserEntity O WHERE O.name = :name1  OR O.name = :name2 ")
    List<UserEntity> findTwoName(@Param("name1") String name1, @Param("name2") String name2);


    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE name = :name1  OR name = :name2 ")
    List<UserEntity> findSQL(@Param("name1") String name1, @Param("name2") String name2);


    @Query("SELECT U FROM UserEntity U ,RoleUserEntity RU WHERE U.id = RU.userId AND RU.roleId = :roleId")
    List<UserEntity> findUsersByRole(@Param("roleId") Long roleId);

}
