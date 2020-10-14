package com.example.lte.repo;

import com.example.lte.entity.RoleUserEntity;
import com.example.lte.entity.RoleUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleUserId为联合主键
 */
@Repository
public interface RoleUserRelRepo extends JpaRepository<RoleUserEntity, RoleUserId> {
}
