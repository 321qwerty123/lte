package com.example.lte.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * UserEntity
 * <p>
 * https://blog.csdn.net/kai46385076/article/details/79930846?utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~first_rank_v2~rank_v25-1-79930846.nonecase&utm_term=jpa%20%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90%E8%A1%A8%E6%B3%A8%E9%87%8A&spm=1000.2123.3001.4430
 * JPA 通过注解自动生成表，添加 字段名、类型、注释
 * https://blog.csdn.net/u011442726/article/details/104015623
 * JPA添加唯一索引约束,添加普通索引
 *
 * @author lzh
 * @Table - 映射表名
 * @Id - 主键
 * @GeneratedValue(strategy=GenerationType.IDENTITY) - 自动递增生成
 * @Column(name = “dict_name”,columnDefinition=”varchar(100) COMMENT ‘字典名’”) - 字段名、类型、注释
 * @UpdateTimestamp - 更新时自动更新时间
 * @CreationTimestamp - 创建时自动更新时间
 * @Version - 版本号，更新时自动加1
 * @date 2020/10/13 - 11:45
 */
@Entity
@Data
@Table(name = "user"
        ,indexes = {@Index(columnList = "name")}
        ,uniqueConstraints=@UniqueConstraint(columnNames={"account"}))
@org.hibernate.annotations.Table(appliesTo = "user", comment = "表注释--用户表")
public class UserEntity {

    @Id
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name", columnDefinition = "varchar(50) COMMENT '用户中文名'")
    private String name;

    @Basic
    @Column(name = "account", columnDefinition = "varchar(50) NOT NULL COMMENT '登录账户'")
    private String account;

    @Basic
    @Column(name = "pwd", columnDefinition = "varchar(255) NOT NULL COMMENT '登录密码'")
    private String password;


    @CreationTimestamp
    @Column(name = "add_time", columnDefinition = "DATETIME COMMENT '添加时间'")
    private Timestamp addTime;

    @UpdateTimestamp
    @Column(name = "update_time", columnDefinition = "DATETIME COMMENT '最后更新时间'")
    private Timestamp updateTime;


    @Version
    @Column(name = "version", columnDefinition = "bigint COMMENT '版本号'")
    private Long version;
}
