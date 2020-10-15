package com.example.lte;

import com.example.lte.entity.*;
import com.example.lte.repo.*;
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

import java.util.*;
import java.util.stream.Collectors;


@SpringBootTest
class LteApplicationTests {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RoleUserRelRepo roleUserRelRepo;
    @Autowired
    private ButtonRepo buttonRepo;
    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    private RoleMenuRelRepo roleMenuRelRepo;
    @Autowired
    private RoleButtonRelRepo roleButtonRelRepo;
    @Autowired
    private IUserService iUserService;


    @Test
    void role1() {
//        roleRepo.save(RoleEntity.builder()
//                .name("dev").note("开发").build());

//        roleRepo.save(RoleEntity.builder()
//                .name("admin").note("管理员").build());
//        roleRepo.save(RoleEntity.builder()
//                .name("user").note("用户").build());
//        roleRepo.save(RoleEntity.builder()
//                .name("test").note("测试").build());

        roleUserRelRepo.save(RoleUserEntity.builder()
                .roleId(roleRepo.findByName("test").getId())
                .userId(userRepo.findByAccount("lhc").getId())
                .build());


    }

    @Test
    void getPerm() {
        Long userId = userRepo.findByAccount("lhc").getId();
        List<RoleUserEntity> list1 = roleUserRelRepo.findByUserId(userId);
        //roleIds
        List<Long> roleIds = list1.stream().map(RoleUserEntity::getRoleId).distinct().collect(Collectors.toList());
        System.out.println(roleIds);

        //dev
//        RoleUserEntity devAcc = list1.stream().filter(a -> a.getRoleId() == 1L).findAny().orElse(null);
//        if (devAcc != null) {
//
//            List<MenuEntity> mList = menuRepo.findAll();
//            System.out.println(mList);
//
//            List<ButtonEntity> bList = buttonRepo.findAll();
//            System.out.println(bList);
//
//
//        }else {

//            List<Long> prs = roleIds.stream().filter(b-> b!=1L).distinct().collect(Collectors.toList());


            List<MenuEntity> resultM = new ArrayList<>();
            List<ButtonEntity> resultB = new ArrayList<>();
        roleIds.forEach(p->{
                resultM.addAll(menuRepo.findMenuEntitiesByRoleId(p));
                resultB.addAll( buttonRepo.findButtonEntitiesByRoleId(p));
            });

            Set<MenuEntity> setMenu = new HashSet<>(resultM);
            Set<ButtonEntity> setBtn = new HashSet<>(resultB);




//        }


    }


    @Test
    void tmenu() {

//        MenuEntity m1 = menuRepo.save(MenuEntity.builder()
//                .note("个人中心")
//                .routerComponent("Personal")
//                .routerName("Personal")
//                .routerPath("/personal")
//                .build());
//
//        ButtonEntity b1 = buttonRepo.save(ButtonEntity.builder()
//                .buttonName("editPersonal")
//                .note("编辑")
//                .build());
//
//        RoleMenuEntity rm1 = roleMenuRelRepo.save(RoleMenuEntity.builder()
//                .menuId(m1.getMenuId())
//                .roleId(roleRepo.findByName("dev").getId())
//                .build());
//
//        roleButtonRelRepo.save(RoleButtonEntity.builder()
//                .buttonId(b1.getButtonId())
//                .roleId(rm1.getRoleId())
//                .build());


        MenuEntity m2 = menuRepo.save(MenuEntity.builder()
                .note("用户管理")
                .routerComponent("AccountManage")
                .routerName("AccountManage")
                .routerPath("/accountManage")
                .build());


        ButtonEntity b2 = buttonRepo.save(ButtonEntity.builder()
                .buttonName("editAccount")
                .note("编辑")
                .build());
        ButtonEntity b3 = buttonRepo.save(ButtonEntity.builder()
                .buttonName("addAccount")
                .note("新增")
                .build());
        ButtonEntity b4 = buttonRepo.save(ButtonEntity.builder()
                .buttonName("delAccount")
                .note("删除")
                .build());
        RoleMenuEntity rm1 = roleMenuRelRepo.save(RoleMenuEntity.builder()
                .menuId(m2.getMenuId())
                .roleId(roleRepo.findByName("dev").getId())
                .build());

        roleButtonRelRepo.save(RoleButtonEntity.builder()
                .buttonId(b2.getButtonId())
                .roleId(rm1.getRoleId())
                .build());
        roleButtonRelRepo.save(RoleButtonEntity.builder()
                .buttonId(b3.getButtonId())
                .roleId(rm1.getRoleId())
                .build());
        roleButtonRelRepo.save(RoleButtonEntity.builder()
                .buttonId(b4.getButtonId())
                .roleId(rm1.getRoleId())
                .build());


    }

    @Test
    void tuserrole1() {
        List<UserEntity> res1 = userRepo.findByNameIsLike("风%");
        List<UserEntity> res2 = userRepo.findByNameIsLike("%风");
        List<UserEntity> res3 = userRepo.findByNameIsLike("%风%");
        System.out.println(res1 + "\n");
        System.out.println(res2 + "\n");
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

        if (optionalUserEntity.isPresent()) {
            System.out.println(optionalUserEntity.get().toString());
        }


        // 按account 降序
        List<UserEntity> userDOList = userRepo.findAll(Sort.by(Sort.Direction.DESC, "account"));
        userDOList.forEach(u -> {
            System.out.println(u.toString());
        });


        UserEntity u1 = userRepo.findByAccount("wentian");
        System.out.println(u1);

        Thread.sleep(3000);

        UserEntity u2 = userRepo.findByAccountAndPassword("fengqy", "123456");
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


        int page = 0, size = 3;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        UserEntity p = new UserEntity();
        p.setName("风");

        ObjectMapper mapper = new ObjectMapper();


        Page<UserEntity> page1 = iUserService.findByCondition(p, pageable);

        String jsonStr = mapper.writeValueAsString(page1);
        System.out.println(jsonStr);


        Pageable pageable2 = PageRequest.of(1, 3, sort);
        Page<UserEntity> page2 = iUserService.findByCondition(p, pageable2);
        String jsonStr2 = mapper.writeValueAsString(page2);
        System.out.println(jsonStr2);


//        for (UserEntity userDetail:page1){
//            System.out.println("userDetail: "+userDetail.toString());
//        }
    }

}
