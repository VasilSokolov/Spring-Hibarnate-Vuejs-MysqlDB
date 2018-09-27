package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
public class UserControllerTest {

    private static final long USER_ID = 1L;
    public static final String USERNAME= "pesho";

    private User user;

    @Autowired
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        //Arrange
        this.user = this.userService.findOne(USER_ID);
//        userService.save(user);
//        when(userService.findOne(USER_ID)).thenReturn(user);
    }

    @Test
    public void getOneUser_ByUsername() throws Exception {
        //Act
//        User user = this.userService.findOne(USER_ID);
        //Assert
        assertEquals(this.user.getUsername(), USERNAME);
    }

    @Test
    public void getUser_IfExist() throws Exception {
        //Act
//        User user = this.userService.findOne(USER_ID);
        //Assert
        assertThat(this.user.getUsername(), is(notNullValue()));
    }

    @Test
    public void findAllShouldReturnCorrectSizeList() throws Exception {
        int listSize = 2;

//       for (int i = 0; i < listSize ; i++) {
//           this.userService.save(new User());
//        }

        List<User> users = this.userService.findAll();

        assertEquals(listSize, users.size());
    }
}
