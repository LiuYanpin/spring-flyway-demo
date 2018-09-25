package com.thoughtworks;

import com.thoughtworks.domain.Address;
import com.thoughtworks.domain.Privilege;
import com.thoughtworks.domain.Role;
import com.thoughtworks.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(applicationContext).build();
    }

    @Test
    void should_get_user() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void should_get_role() {
        Role role = new Role();
        assertNotNull(role);
    }

    @Test
    void should_get_privilege() {
        Privilege privilege = new Privilege();
        assertNotNull(privilege);
    }

    @Test
    void should_get_role_id() {
        User user = new User();
        assertNotNull(user);
        boolean flag = false;
        Annotation[] annotations = user.getClass().getAnnotations();
        for (Annotation annotation: annotations) {
            if (annotation.getClass().equals(Table.class)) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    void should_get_user_id() {
        Role role = new Role();
        assertNotNull(role);
        assertNotNull(role.getUser());

    }

    @Test
    void should_get_address() {
        Address address = new Address();
        assertNotNull(address);
    }
}


