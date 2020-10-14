package com.example.lte.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * @author liuzh
 */
@Data
public class RoleMenuId implements Serializable {

    private Long roleId;
    private Long menuId;

}
