package com.example.lte.repo;

import com.example.lte.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<MenuEntity,Long> {

    MenuEntity findByRouterPath(String routerPath);

    @Query("select m from  MenuEntity m ,RoleMenuEntity rm where m.menuId = rm.menuId and rm.roleId = :roleId")
    List<MenuEntity> findMenuEntitiesByRoleId(@Param("roleId") Long roleId);


}
