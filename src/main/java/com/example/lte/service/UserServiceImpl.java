package com.example.lte.service;

import cn.dev33.satoken.stp.StpUtil;
import com.example.lte.entity.UserEntity;
import com.example.lte.po.LoginPO;
import com.example.lte.repo.UserRepo;
import com.example.lte.restful.APIException;
import com.example.lte.restful.ResultCodeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lzh
 * @date 2020/10/13 - 14:30
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private UserRepo userRepo;

    /**
     * JpaSpecificationExecutor 多条件动态查询 类似于 mybatis xml里的if标签
     * @param detailParam UserEntity
     * @param pageable Pageable
     * @return  Page<UserEntity>
     */
    @Override
    public Page<UserEntity> findByCondition(UserEntity detailParam, Pageable pageable) {
        //     Page<T> findAll(@Nullable Specification<T> var1, Pageable var2);
        // 这里使用匿名Lamda实现 Specification
        // cb指sql条件构建器 javax.persistence.criteria.CriteriaBuilder
        // query指 sql查询器 javax.persistence.criteria.CriteriaQuery
        // root指   javax.persistence.criteria.Path
        //这里的匿名lambda写法是 jpa提供的，参考 org.springframework.data.jpa.domain.Specification
        return userRepo.findAll( (root, query, cb)->{
            List<Predicate> predicates = new ArrayList<>();
            //equal 示例
            if (!StringUtils.isEmpty(detailParam.getAccount())){
                predicates.add(cb.equal(root.get("account"),detailParam.getAccount()));
            }

            //like 示例
            if (!StringUtils.isEmpty(detailParam.getName())){
                predicates.add(cb.like(root.get("name"),"%"+detailParam.getName()+"%"));
            }

            //between 示例
            /*if (detailParam.getMinAge()!=null && detailParam.getMaxAge()!=null) {
                Predicate agePredicate = cb.between(root.get("age"), detailParam.getMinAge(), detailParam.getMaxAge());
                predicates.add(agePredicate);
            }
            //greaterThan 大于等于示例
            if (detailParam.getMinAge()!=null){
                predicates.add(cb.greaterThan(root.get("age"),detailParam.getMinAge()));
            }*/


            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

    @Override
    public LoginPO doLogin(String account, String pwd) {

        if (userRepo.findByAccount(account) != null){
            UserEntity u1 = userRepo.findByAccountAndPassword(account,pwd);
            if (u1 == null){
                throw new APIException(ResultCodeEnum.ACCOUNT_PASS_FAILED);
            }else {
                StpUtil.setLoginId(u1.getAccount());
                String tokenValue = StpUtil.getTokenInfo().get("tokenValue");
                return LoginPO.builder()
                        .account(account)
                        .token(tokenValue)
                        .userId(u1.getId())
                        .userName(u1.getName())
                        .build();

            }
        }else {
            throw new APIException(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
    }
}
