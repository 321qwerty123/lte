package com.example.lte.entity;

import javax.persistence.*;

/**
 * @author lzh
 * @date 2020/10/13 - 14:11
 */
@Entity
@Table(name = "role")
public class RoleEntity {
    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * 角色name
     */
    @Column(length = 32)
    private String name;
    /**
     * 角色note
     */
    @Column(length = 64)
    private String note;
}
