package com.example.lte.entity;

import javax.persistence.*;

/**
 * @author lzh
 * @date 2020/10/13 - 14:16
 */
@Entity
@IdClass(RoleUserId.class)
@Table(name = "role_user")
public class RoleUserEntity {
    @Id
    private Long roleId;
    @Id
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
