package com.example.lte.repo;

import com.example.lte.entity.RoleUserEntity;
import com.example.lte.entity.RoleUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleUserId为联合主键
 */
@Repository
public interface RoleUserRelRepo extends JpaRepository<RoleUserEntity, RoleUserId> {

    List<RoleUserEntity> findByUserId(Long userId);

    List<RoleUserEntity> findByRoleId(Long roleId);

    RoleUserEntity findByRoleIdAndUserId(Long roleId , Long userId);
}
