package com.example.lte.po;

import com.example.lte.entity.ButtonEntity;
import com.example.lte.entity.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author lzh
 * @date 2020/10/15 - 17:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermPO {

    private Long userId;

    private List<Long> roleIds;

    private Set<MenuEntity> menuEntitySet;

    private  Set<ButtonEntity> buttonEntitySet;
}
