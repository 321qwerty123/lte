package com.example.lte.service;

import com.example.lte.entity.UserEntity;
import com.example.lte.po.LoginPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lzh
 * @date 2020/10/13 - 14:28
 */

public interface IUserService {

    /**
     * JpaSpecificationExecutor 多条件动态查询 类似于 mybatis xml里的if标签
     * @param detailParam
     * @param pageable
     * @return
     */
    Page<UserEntity> findByCondition(UserEntity detailParam, Pageable pageable);


    LoginPO doLogin(String account ,String pwd);
}
