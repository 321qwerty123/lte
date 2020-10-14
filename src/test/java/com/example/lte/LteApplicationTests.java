package com.example.lte;

import com.example.lte.entity.RoleEntity;
import com.example.lte.entity.RoleUserEntity;
import com.example.lte.entity.UserEntity;
import com.example.lte.repo.RoleRepo;
import com.example.lte.repo.RoleUserRelRepo;
import com.example.lte.repo.UserRepo;
import com.example.lte.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class LteApplicationTests {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RoleUserRelRepo roleUserRelRepo;
    @Autowired
    private IUserService iUserService;


    @Test
    void role1(){
        roleRepo.save(RoleEntity.builder()
                .name("dev").note("开发").build());

    }

    @Test
    void tmenu(){

    }

    @Test
    void tuserrole1(){
      List<UserEntity> res1 =  userRepo.findByNameIsLike("风%");
      List<UserEntity> res2 =  userRepo.findByNameIsLike("%风");
      List<UserEntity> res3 =  userRepo.findByNameIsLike("%风%");
        System.out.println(res1+"\n");
        System.out.println(res2+"\n");
        System.out.println(res3);

        roleUserRelRepo.save(RoleUserEntity.builder()
                .roleId(roleRepo.findByName("dev").getId())
                .userId(userRepo.findByAccount("lhc").getId())
                .build());
    }

    @Test
     void before() throws InterruptedException {
        UserEntity userDO = new UserEntity();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO = new UserEntity();
        userDO.setId(3L);
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO.setId(5L);
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPassword("123456");
        userRepo.save(userDO);

//        userRepo.deleteById(1L);

        Optional<UserEntity> optionalUserEntity = userRepo.findById(3L);

        if (optionalUserEntity.isPresent()){
            System.out.println(optionalUserEntity.get().toString());
        }


        // 按account 降序
        List<UserEntity> userDOList = userRepo.findAll(Sort.by(Sort.Direction.DESC,"account"));
        userDOList.forEach(u->{
            System.out.println(u.toString());
        });


        UserEntity u1 = userRepo.findByAccount("wentian");
        System.out.println(u1);

        Thread.sleep(3000);

        UserEntity u2 = userRepo.findByAccountAndPassword("fengqy","123456");
        u2.setPassword("147258");
        userRepo.save(u2);
        System.out.println(u2);


    }

    @Test
    void contextLoads() throws JsonProcessingException {

        UserEntity userDO = new UserEntity();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO.setId(2L);
        userDO.setName("风二中");
        userDO.setAccount("f2");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO.setId(3L);
        userDO.setName("风33");
        userDO.setAccount("f3");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO.setId(4L);
        userDO.setName("风44");
        userDO.setAccount("f4");
        userDO.setPassword("123456");
        userRepo.save(userDO);

        userDO.setId(5L);
        userDO.setName("风55");
        userDO.setAccount("f5");
        userDO.setPassword("123456");
        userRepo.save(userDO);




        int page=0,size=3;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        UserEntity p = new UserEntity();
        p.setName("风");

        ObjectMapper mapper = new ObjectMapper();


        Page<UserEntity>  page1 = iUserService.findByCondition(p,pageable);

        String jsonStr = mapper.writeValueAsString(page1);
        System.out.println(jsonStr);


        Pageable pageable2 = PageRequest.of(1, 3, sort);
        Page<UserEntity>  page2 = iUserService.findByCondition(p,pageable2);
        String jsonStr2 = mapper.writeValueAsString(page2);
        System.out.println(jsonStr2);


//        for (UserEntity userDetail:page1){
//            System.out.println("userDetail: "+userDetail.toString());
//        }
    }

}
