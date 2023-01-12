package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collection;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootRestApplicationTests {
    UserController userController = new UserController();
//    @Test
//    void contextLoads() {
//
//    }
    //Create User
    @Test
        public void testUserController_createUser(){
        User user1 = new User("jbp","jbp@test.com");
        userController.createUser(user1);
        assertEquals("jbp",user1.getName());
        }

        //Get the user
    @Test
    public void testUserController_getUsers(){
        User user1 = new User("jbp","jbp@test.com");
        User user2 = new User("test","test@test.com");

        userController.createUser(user1);
        userController.createUser(user2);

        Collection<User> users = userController.getAllUsers();

        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    public void testUserController_updateUsers(){
        User user2 = new User("jbp", "jbp@test.com");
        user2.setName("JBP");
        userController.updateUser("jbp@test.com", user2);
        assertEquals(user2, userController.getUserByEmail("jbp@test.com"));
    }

    @Test
    public void testUserController_Delete(){
        User user1 = new User("jbp", "jbp@test.com");
        userController.deleteUserByEmail("jbp@test.com");
        assertNull(userController.getUserByEmail("jbp@test.com"));
    }



}
