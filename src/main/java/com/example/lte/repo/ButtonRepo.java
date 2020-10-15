package com.example.lte.repo;

import com.example.lte.entity.ButtonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButtonRepo extends JpaRepository<ButtonEntity,Long> {

    ButtonEntity findByButtonName(String btnName);


    @Query("select b from ButtonEntity b,RoleButtonEntity rb where b.buttonId = rb.buttonId and rb.roleId = :roleId")
    List<ButtonEntity> findButtonEntitiesByRoleId(@Param("roleId") Long roleId);



}
