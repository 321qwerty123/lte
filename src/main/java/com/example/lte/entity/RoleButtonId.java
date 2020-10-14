package com.example.lte.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class RoleButtonId implements Serializable {
    private Long roleId;
    private Long buttonId;
}
