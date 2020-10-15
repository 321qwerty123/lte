package com.example.lte.repo;

import com.example.lte.entity.RoleMenuEntity;
import com.example.lte.entity.RoleMenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuRelRepo extends JpaRepository<RoleMenuEntity, RoleMenuId> {

    List<RoleMenuEntity> findByRoleId(Long roleId);




}
