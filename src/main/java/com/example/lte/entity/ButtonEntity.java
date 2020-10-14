package com.example.lte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lte_button",uniqueConstraints=@UniqueConstraint(columnNames={"buttonName"}))
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ButtonEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long buttonId;


    @Column(length = 50)
    private String buttonName;
}
