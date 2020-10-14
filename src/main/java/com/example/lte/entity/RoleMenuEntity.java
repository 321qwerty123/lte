package com.example.lte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(RoleMenuId.class)
@Table(name = "role_menu")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuEntity {

    @Id
    private Long roleId;

    @Id
    private Long menuId;


}
