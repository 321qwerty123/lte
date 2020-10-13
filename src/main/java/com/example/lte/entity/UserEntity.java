package com.example.lte.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @author lzh
 * @date 2020/10/13 - 11:45
 */
@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32,name = "name")
    private String name;

    @Column(length = 32,name="account")
    private String account;

    @Column(length = 64,name="pwd")
    private String password;


}
