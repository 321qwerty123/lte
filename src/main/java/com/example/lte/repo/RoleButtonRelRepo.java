package com.example.lte.repo;

import com.example.lte.entity.RoleButtonEntity;
import com.example.lte.entity.RoleButtonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleButtonRelRepo extends JpaRepository<RoleButtonEntity, RoleButtonId> {
}
