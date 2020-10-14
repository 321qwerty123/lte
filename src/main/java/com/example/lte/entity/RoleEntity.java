package com.example.lte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author lzh
 * @date 2020/10/13 - 14:11
 */
@Entity
@Table(name = "role",uniqueConstraints=@UniqueConstraint(columnNames={"name"}))
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
