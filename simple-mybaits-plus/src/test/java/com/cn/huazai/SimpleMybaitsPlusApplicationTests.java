package com.cn.huazai;

import com.cn.huazai.modular.entity.Calllog;
import com.cn.huazai.modular.entity.Imei;
import com.cn.huazai.modular.entity.Msglog;
import com.cn.huazai.modular.entity.Users;
import com.cn.huazai.modular.service.CalllogService;
import com.cn.huazai.modular.service.ImeiService;
import com.cn.huazai.modular.service.MsglogService;
import com.cn.huazai.modular.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleMybaitsPlusApplicationTests {

    @Autowired
    private UsersService usersService;

    @Autowired
    private MsglogService msglogService;

    @Autowired
    private CalllogService calllogService;

    @Autowired
    private ImeiService imeiService;

    @Test
    public void addUser() {
        List<Users> list = new ArrayList<>();
        for (int i = 500; i < 3000; i++) {
            Users users = new Users();
            users.setUsername("华仔" + i);
            users.setNickname("华仔" + i);
            users.setSecret("e10adc3949ba59abbe56e057f20f883e");
            users.setPassword("e10adc3949ba59abbe56e057f20f883e");
            users.setEmployeeid("" + (i - 499));
            users.setImeiid(i - 499);
            users.setCreated((int) (System.currentTimeMillis() / 1000));
            list.add(users);
        }
        usersService.saveBatch(list);
    }

    @Test
    public void addImei() {
        List<Imei> list = new ArrayList<>();
        for (int i = 500; i < 3000; i++) {
            Imei imei = new Imei();
            imei.setId(i);

            imei.setImei("UYT7N18227000268" + i);
            list.add(imei);
        }
        imeiService.saveBatch(list);
    }

    @Test
    public void addMsgLog() {
        List<Msglog> list = new ArrayList<>();
        for (int i = 500; i < 10000; i++) {
            Msglog msg = new Msglog();

            msg.setFromuser(i);
            msg.setTouser(i + 1);
            msg.setStarttime(LocalDateTime.now());
            list.add(msg);
        }
        msglogService.saveBatch(list);
    }

    @Test
    public void addCalLog() {
        List<Calllog> list = new ArrayList<>();
        for (int i = 500; i < 10000; i++) {
            Calllog calllog = new Calllog();
            calllog.setStarttime(LocalDateTime.now());
            calllog.setFromuser(i);
            calllog.setTouser(i + 1);
            calllog.setGuid("12000" + i);
            list.add(calllog);
        }
        calllogService.saveBatch(list);
    }
}
