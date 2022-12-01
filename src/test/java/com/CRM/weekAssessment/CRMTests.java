package com.CRM.weekAssessment;

import com.CRM.weekAssessment.entities.User;
import com.CRM.weekAssessment.services.UserServices;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=WeekAssessmentApplication.class)
@Transactional
public class CRMTests {

    @Autowired
    private  UserServices userServices ;

    @Test
    public void loginFail() {

        String email = "test@test.com";
        String password = "test";

        assertFalse(userServices.loginUser(email, password));
    }

    @Test
    public void loginSuccess() {

        String email = "admin@solera.com";
        String password = "admin";

        assertTrue(userServices.loginUser(email, password));
    }

    @Test
    public void repeatedUser() {

        User user = new User();

        user.setEmail("admin@solera.com");

        assertTrue(userServices.getUserByEmail(user.getEmail()));

    }

    @Test
    public void nonRepeatedUser() {

        User user = new User();

        user.setEmail("admin@solera.es");

        assertFalse(userServices.getUserByEmail(user.getEmail()));

    }
}
