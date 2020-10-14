package com.example.lte.repo;

import com.example.lte.entity.RoleMenuEntity;
import com.example.lte.entity.RoleMenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRelRepo extends JpaRepository<RoleMenuEntity, RoleMenuId> {
}
