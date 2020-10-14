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
@IdClass(RoleButtonId.class)
@Table(name = "role_button")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleButtonEntity {
    @Id
    private Long roleId;
    @Id
    private Long buttonId;
}
