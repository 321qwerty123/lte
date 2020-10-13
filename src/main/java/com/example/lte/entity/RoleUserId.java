package com.example.lte.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * JPA联合主键对象
 *
 * @author lzh
 * @date 2020/10/13 - 14:15
 */
@Data
public class RoleUserId  implements Serializable {
    private Long roleId;
    private Long userId;
}
