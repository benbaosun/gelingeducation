package com.project.gelingeducation.service;

import com.project.gelingeducation.entity.LoginLog;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(locations = {"/spring/application-data.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginLogServiceTest {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    private ILoginLogService loginLogService;

    @Test
    public void test() {
        LoginLog loginLog = new LoginLog();
        loginLog.setUid(new Long(1));
        loginLog.setLoginTime(new Date());
        loginLog.setBrowser("11");
        loginLog.setLocation("1");
        loginLog.setUserSystem("11");
        loginLogService.insert(loginLog);
    }

    @Test
    public void test1() {
        List<LoginLog> list = (List<LoginLog>) loginLogService.queryAll(1,3);
        for (int i = 0; i < list.size(); i++) {
            log.debug("==>" + list.get(i).getLoginTime());
        }
    }
}
