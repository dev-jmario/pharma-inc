package com.challenge.pharmainc.controller;

import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.service.CrudService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CrudControllerTest {

    @Mock
    private CrudService service;

    @InjectMocks
    private CrudController controller;

    @Test
    public void doUpdateUser(){
        Integer id = Integer.valueOf(1);
        User user = User.builder()
                .id(id)
                .nameFirst("Diego")
                .nameLast("Maradona")
                .nameTitle("Mr")
                .email("test@email.com.br")
                .build();

        Mockito.when(service.findById(id)).thenReturn(user);
        Mockito.when(service.updateUser(user)).thenReturn(user);

        ResponseEntity<User> response = controller.updateUser(id);
        Assertions.assertTrue(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void doDeleteUserNotFound(){
        Integer id = Integer.valueOf(1);

        Mockito.when(service.findById(id)).thenReturn(null);
        ResponseEntity<Void> response = controller.deleteUser(id);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void doFindById(){
        Integer id = Integer.valueOf(1);

        User user = User.builder()
                        .id(id)
                        .nameFirst("Michael")
                        .nameLast("Jackson")
                        .nameTitle("Mr")
                        .email("test@email.com.br")
                        .build();

        Mockito.when(service.findById(id)).thenReturn(user);
        ResponseEntity<User> response = controller.findById(id);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void doFindAll(){
        List<User> users = Arrays.asList(
                User.builder()
                        .nameFirst("Test")
                        .nameLast("Silva")
                        .nameTitle("Dr")
                        .email("test@email.com.br")
                        .build()
        );

        Mockito.when(service.findAll()).thenReturn(users);
        ResponseEntity<List<User>> response = controller.findAll();
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
