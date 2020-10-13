package com.example.lte.repo;

import com.example.lte.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lzh
 * @date 2020/10/13 - 14:17
 */
@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,Long> {
}
