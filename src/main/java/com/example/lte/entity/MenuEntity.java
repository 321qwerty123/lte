package com.example.lte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lte_menu",uniqueConstraints = @UniqueConstraint(columnNames = {"routerName","routerPath"}) )
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long menuId;

    @Column(length = 64)
    private String note;

    /**
     *  {
     *         path: '/home',
     *         name: 'Home',
     *         component: Home
     *     },
     */

    @Column(length = 100)
    private String routerName;

    @Column(length = 100)
    private String routerPath;

    @Column(length = 100)
    private String routerComponent;
}
