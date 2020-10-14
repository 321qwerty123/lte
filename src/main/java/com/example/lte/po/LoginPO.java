package com.example.lte.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuzh
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginPO {
    private Long userId;
    private String userName;
    private String account;
    private String token;
}
